package com.android.shopapp.entity

data class Post(
    val category_id: Int,
    val description: String,
    val id: Int,
    val owner: Int,
    val price: Double,
    val price_type: String,
    val tags: String,
    val title: String,
    val urls: List<String>
)