package com.android.shopapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.size
import androidx.recyclerview.widget.RecyclerView
import com.android.shopapp.databinding.PostItemBinding
import com.android.shopapp.entity.Post
import com.android.shopapp.extensions.hide

class PostRecyclerViewAdapter(private val items: List<Post>) :
    RecyclerView.Adapter<PostRecyclerViewAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ItemViewHolder(
        PostItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.onBind()
    }

    override fun getItemCount() = items.size

    inner class ItemViewHolder(private val binding: PostItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private lateinit var item: Post

        fun onBind() {
            item = items[adapterPosition]
            binding.descriptionTV.text = item.description
            binding.priceTV.text = item.price.toString()
            binding.productTypeTV.text = item.tags
            binding.titleTV.text = item.title
            binding.cartBTN.signInBtn.text = "Add To Cart"
            binding.viewPager.adapter = PostPhotoViewPagerAdapter(item.urls)
            if (item.urls.size <= 1) {
                binding.leftArrBTN.hide()
                binding.rightArrBTN.hide()
            }
            binding.leftArrBTN.setOnClickListener {
                binding.viewPager.post {
                    val back: Int = binding.viewPager.currentItem - 1
                    if (back >= 0)
                        binding.viewPager.currentItem = back
                }
            }

            binding.rightArrBTN.setOnClickListener {
                binding.viewPager.post {
                    val next: Int = binding.viewPager.currentItem + 1
                    if (next < binding.viewPager.size)
                        binding.viewPager.currentItem = next
                }
            }

        }
    }
}