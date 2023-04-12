package com.example.recyclerview_with_video_images.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.recyclerview_with_video_images.repository.Repository
import com.example.recyclerview_with_video_images.viewModels.MainTrailerViewModel

class MainTrailerFactory(private val repository: Repository): ViewModelProvider.Factory  {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainTrailerViewModel(repository) as T
    }

}