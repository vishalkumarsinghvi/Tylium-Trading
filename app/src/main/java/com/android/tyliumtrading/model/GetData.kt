package com.android.tyliumtrading.model

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET

interface GetData {
    @GET("prices")
    fun getData(): Call<JsonObject>
}