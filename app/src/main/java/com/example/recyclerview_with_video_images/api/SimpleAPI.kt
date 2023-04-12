package com.example.recyclerview_with_video_images.api

import com.example.recyclerview_with_video_images.models.MovieTrailerItem
import retrofit2.Response
import retrofit2.http.GET

interface SimpleAPI {
    @GET("Api.php?apicall=pulls")
    suspend fun getTrailers(
//        @Query("albumId") albumId: Int,
//        @Query("_sort") sort: String,
//        @Query("_order") order: String
    ): Response<List<MovieTrailerItem>>

}