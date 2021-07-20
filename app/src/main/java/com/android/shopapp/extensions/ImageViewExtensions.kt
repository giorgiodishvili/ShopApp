package com.android.shopapp.extensions

import android.widget.ImageView
import com.android.shopapp.R
import com.bumptech.glide.Glide

fun ImageView.loadImg(url: String) {
    Glide.with(this.context)
        .load(url)
        .fitCenter()
        .placeholder(R.drawable.ic_launcher_foreground)
        .error(R.drawable.ic_launcher_foreground)
        .into(this)
}