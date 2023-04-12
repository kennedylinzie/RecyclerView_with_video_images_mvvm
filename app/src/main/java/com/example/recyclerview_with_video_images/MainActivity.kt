package com.example.recyclerview_with_video_images

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.recyclerview_with_video_images.adapter.MyAdapter
import com.example.recyclerview_with_video_images.databinding.ActivityMainBinding
import com.example.recyclerview_with_video_images.factories.MainTrailerFactory
import com.example.recyclerview_with_video_images.repository.Repository
import com.example.recyclerview_with_video_images.viewModels.MainTrailerViewModel

class MainActivity : AppCompatActivity() {


    private lateinit var viewModel: MainTrailerViewModel
    lateinit var bind: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        val mainAdapter = MyAdapter()

        val repository = Repository()
        val viewModelFactory = MainTrailerFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory)[MainTrailerViewModel::class.java]
        bind.recyclerView.apply {
            adapter = mainAdapter
        }

            viewModel.getTrailers()
            viewModel.myResponse.observe(this, Observer {
                if (it.isSuccessful){
                    mainAdapter.submitList(it.body())
                    mainAdapter.notifyDataSetChanged()
                }else{

                }
            })

        viewModel.getTrailers()
        viewModel.myResponse.observe(this, Observer {
            if (it.isSuccessful){
                mainAdapter.submitList(it.body())
                mainAdapter.notifyDataSetChanged()
            }else{

            }
        })
    }
}