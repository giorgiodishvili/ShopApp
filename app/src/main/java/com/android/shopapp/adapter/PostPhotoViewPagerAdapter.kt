package com.android.shopapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.shopapp.databinding.ViewPagerPhotoItemBinding
import com.android.shopapp.entity.ImageUrl
import com.android.shopapp.extensions.loadImg

class PostPhotoViewPagerAdapter(private val photos: List<ImageUrl>) :
    RecyclerView.Adapter<PostPhotoViewPagerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ViewPagerPhotoItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind()
    }

    override fun getItemCount() = photos.size

    inner class ViewHolder(private val binding: ViewPagerPhotoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind() {
            binding.image.loadImg(photos[adapterPosition].url)
        }


    }

}