package com.example.recyclerview_with_video_images.api

import com.example.recyclerview_with_video_images.constants.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder().baseUrl(
            Constants.BASE_URL
        ).addConverterFactory(GsonConverterFactory.create()).build()
    }
    val api:SimpleAPI by lazy {
        retrofit.create(SimpleAPI::class.java)
    }

}