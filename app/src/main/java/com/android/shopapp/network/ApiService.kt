package com.android.shopapp.network

import com.android.shopapp.entity.Post
import com.android.shopapp.entity.login.LogInRequest
import com.android.shopapp.entity.login.LogInResponse
import com.android.shopapp.entity.register.RegisterRequest
import com.android.shopapp.entity.register.RegisterResponse
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @POST("login")
    suspend fun login(@Body login: LogInRequest): Response<LogInResponse>

    @POST("register")
    suspend fun register(@Body register: RegisterRequest): Response<RegisterResponse>

    @GET("/posts")
    suspend fun getPosts(): Response<List<Post>>

}