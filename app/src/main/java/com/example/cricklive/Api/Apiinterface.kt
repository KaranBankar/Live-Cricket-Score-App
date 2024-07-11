package com.example.cricklive.Api

import com.example.cricklive.Model.CricketData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Apiinterface {

    @GET("currentMatches")
    fun getLiveScore(@Query("apikey") apikey: String): Call<CricketData>
}
