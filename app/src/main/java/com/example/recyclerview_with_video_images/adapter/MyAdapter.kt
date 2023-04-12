package com.example.recyclerview_with_video_images.adapter

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.example.recyclerview_with_video_images.R
import com.example.recyclerview_with_video_images.ViewTrailer
import com.example.recyclerview_with_video_images.databinding.RowItemBinding
import com.example.recyclerview_with_video_images.models.MovieTrailerItem
import com.squareup.picasso.Picasso

class MyAdapter: ListAdapter<MovieTrailerItem, MyAdapter.ViewHolder>(differ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            RowItemBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    inner class ViewHolder(private val binding: RowItemBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun onBind(message: MovieTrailerItem) {
            with(binding) {

                YoYo.with(Techniques.BounceInUp)
                    .duration(1000)
                    .playOn(itemView)

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, ViewTrailer::class.java)
                    val bundle = Bundle()
                    bundle.putString("title", message.viedeoTitle)
                    bundle.putString("video", message.videoSrc)
                    intent.putExtras(bundle)
                    itemView.context.startActivity(intent)
                }
                this.tvTiltle.text = message.viedeoTitle
                Picasso.get()
                    .load(message.videoAvatar)
                    .placeholder(R.drawable.baseline_autorenew_24)
                    .into(imgPhoto);
            }
        }
    }


    companion object {
        val differ = object : DiffUtil.ItemCallback<MovieTrailerItem>() {

            override fun areContentsTheSame(oldItem: MovieTrailerItem, newItem: MovieTrailerItem): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(oldItem: MovieTrailerItem, newItem: MovieTrailerItem): Boolean {
                return oldItem.viedeoTitle == newItem.viedeoTitle
            }
        }

    }


}