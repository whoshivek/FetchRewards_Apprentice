package com.example.fetchrewards.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
private const val  BASE_URL = "https://fetch-hiring.s3.amazonaws.com/"
class FetchClient {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api: FetchApi = retrofit.create(FetchApi::class.java)

}