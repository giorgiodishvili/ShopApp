package com.android.shopapp.drawer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.shopapp.databinding.PostItemBinding
import com.android.shopapp.entity.Post

class PostRecyclerViewAdapter(private val items: List<Post>) :
    RecyclerView.Adapter<PostRecyclerViewAdapter.ItemViewHolder>() {

    lateinit var drawerItemOnClickListener: drawerItemOnClickListener

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
        }
    }
}