package com.android.shopapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.shopapp.databinding.DrawerItemLayoutBinding
import com.android.shopapp.entity.DrawerItem


typealias drawerItemOnClickListener = (actionId: Int) -> Unit

class DrawerAdapter(private val items: List<DrawerItem>) :
    RecyclerView.Adapter<DrawerAdapter.ItemViewHolder>() {

    lateinit var drawerItemOnClickListener: drawerItemOnClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ItemViewHolder(
        DrawerItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.onBind()
    }

    override fun getItemCount() = items.size

    inner class ItemViewHolder(private val binding: DrawerItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private lateinit var item: DrawerItem

        fun onBind() {
            item = items[adapterPosition]
            binding.item.text = item.name
            binding.item.setOnClickListener {
                drawerItemOnClickListener.invoke(item.id)
            }
        }
    }
}