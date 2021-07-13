package com.android.shopapp.repository.posts

import com.android.shopapp.entity.Post
import retrofit2.Response

interface PostsRepository {
    suspend fun getPosts(): Response<List<Post>>

}