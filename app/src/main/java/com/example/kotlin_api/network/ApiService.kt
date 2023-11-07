package com.example.kotlin_api.network

import com.example.kotlin_api.model.RickModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("character")
    fun getRick(): Call<RickModel>
}