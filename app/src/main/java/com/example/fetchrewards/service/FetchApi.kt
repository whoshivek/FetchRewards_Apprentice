package com.example.fetchrewards.service

import com.example.fetchrewards.model.InformationItems
import retrofit2.Call
import retrofit2.http.GET

interface FetchApi {

    @GET("hiring.json")
    fun getInformation() : Call<List<InformationItems>>

}