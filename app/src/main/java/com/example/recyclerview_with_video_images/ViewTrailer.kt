package com.example.recyclerview_with_video_images

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclerview_with_video_images.databinding.ActivityViewTrailerBinding
import com.example.recyclerview_with_video_images.viewModels.viewTrailerViewModel

class ViewTrailer : AppCompatActivity() {
    private lateinit var binding: ActivityViewTrailerBinding
    private val viewModel by viewModels<viewTrailerViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewTrailerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras // get the bundle from the intent
        val title = bundle?.getString("title")
        val trailerVideo = bundle?.getString("video")

        if (trailerVideo != null) {
            viewModel.setVideo(trailerVideo)
        }

        viewModel.video.observe(this) { value ->
            val uri = Uri.parse(value)
            binding.videoView.setVideoURI(uri)

            val controller = MediaController(this)
            controller.setMediaPlayer(binding.videoView)
            binding.videoView.setMediaController(controller)
            binding.videoView.requestFocus()
            binding.videoView.start()
            binding.videoView.setOnPreparedListener { mp ->
                mp.setVideoScalingMode(MediaPlayer.VIDEO_SCALING_MODE_SCALE_TO_FIT)
                mp.setScreenOnWhilePlaying(true)
                mp.start()
            }
        }
    }
}