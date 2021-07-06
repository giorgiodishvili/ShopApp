package com.android.shopapp.repository

import com.android.shopapp.entity.register.RegisterRequest
import com.android.shopapp.entity.register.RegisterResponse
import com.android.shopapp.network.ApiService
import retrofit2.Response
import javax.inject.Inject

class SignUpRepositoryImpl @Inject constructor(private val apiService: ApiService): SignUpRepository {
    override suspend fun signUp(signUp: RegisterRequest) = apiService.register(signUp)

}