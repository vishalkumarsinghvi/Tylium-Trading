package com.android.tyliumtrading.model

import retrofit2.Call
import retrofit2.http.GET

interface GetData {
    @GET("prices")
    fun getData(): Call<TradingData>
}