package com.example.recyclerview_with_video_images.models


import com.google.gson.annotations.SerializedName

data class MovieTrailerItem(
    @SerializedName("video_avatar")
    val videoAvatar: String,
    @SerializedName("video_id")
    val videoId: String,
    @SerializedName("video_src")
    val videoSrc: String,
    @SerializedName("viedeo_title")
    val viedeoTitle: String
)