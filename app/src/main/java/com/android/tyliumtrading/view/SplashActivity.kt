package com.android.tyliumtrading.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.android.tyliumtrading.R
import com.android.tyliumtrading.model.GetData
import com.android.tyliumtrading.model.TradingData
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_splash.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        init()
    }

    private fun init() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://data-fix.smt-data.com/fixprof/instruments/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val call = retrofit.create(GetData::class.java)
        call.getData().enqueue(object : Callback<TradingData> {
            override fun onResponse(call: Call<TradingData>, response: Response<TradingData>) {
                if (response.code() == 200) {
                    val intent = Intent(this@SplashActivity, HomeActivity::class.java)
                    val b = Bundle()
                    b.putString("data", Gson().toJson(response.body()))
                    intent.putExtras(b)
                    startActivity(intent)
                }
                hideProgress()
            }

            override fun onFailure(call: Call<TradingData>, t: Throwable) {
                hideProgress()
            }
        })

    }

    fun hideProgress() {
        progress_Bar.visibility = View.GONE
    }
}
