package com.example.recyclerview_with_video_images.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recyclerview_with_video_images.models.MovieTrailerItem
import com.example.recyclerview_with_video_images.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainTrailerViewModel(private val repository: Repository):ViewModel() {

    val myResponse : MutableLiveData<Response<List<MovieTrailerItem>>> = MutableLiveData()
    fun getTrailers(){
        viewModelScope.launch {
            val myresponse = repository.getTrailers()
            myResponse.value = myresponse
        }
    }

}