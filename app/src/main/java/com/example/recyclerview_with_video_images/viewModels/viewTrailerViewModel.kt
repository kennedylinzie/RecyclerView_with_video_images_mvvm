package com.example.recyclerview_with_video_images.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class viewTrailerViewModel : ViewModel() {

    private val _video = MutableLiveData<String>()
    val video: LiveData<String> = _video
    fun setVideo(video: String) {
        _video.value = video
    }
}