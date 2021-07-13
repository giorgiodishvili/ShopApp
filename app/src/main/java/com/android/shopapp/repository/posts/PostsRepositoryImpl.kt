package com.android.shopapp.repository.posts

import com.android.shopapp.entity.Post
import com.android.shopapp.network.ApiService
import retrofit2.Response
import javax.inject.Inject

class PostsRepositoryImpl @Inject constructor(private val apiService: ApiService) : PostsRepository {
    override suspend fun getPosts(): Response<List<Post>>  = apiService.getPosts()
}