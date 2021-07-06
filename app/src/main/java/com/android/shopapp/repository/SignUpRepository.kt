package com.android.shopapp.repository

import com.android.shopapp.entity.login.LogInRequest
import com.android.shopapp.entity.login.LogInResponse
import com.android.shopapp.entity.register.RegisterRequest
import com.android.shopapp.entity.register.RegisterResponse
import retrofit2.Response

interface SignUpRepository {
    suspend fun signUp(signUp: RegisterRequest): Response<RegisterResponse>

}
