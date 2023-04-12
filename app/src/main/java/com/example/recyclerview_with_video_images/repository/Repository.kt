package com.example.recyclerview_with_video_images.repository

import com.example.recyclerview_with_video_images.api.RetrofitInstance
import com.example.recyclerview_with_video_images.models.MovieTrailerItem
import retrofit2.Response

class Repository {

    suspend fun getTrailers(): Response<List<MovieTrailerItem>> {
        return  RetrofitInstance.api.getTrailers()
    }


}