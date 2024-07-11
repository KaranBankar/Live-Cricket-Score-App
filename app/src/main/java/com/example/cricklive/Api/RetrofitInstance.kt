package com.example.cricklive.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    companion object{

        private val retrofit by lazy {

            Retrofit.Builder()
                .baseUrl("https://api.cricapi.com/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val api by lazy{
            retrofit.create(Apiinterface::class.java)
        }
    }
}