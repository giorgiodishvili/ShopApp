package com.android.shopapp.repository.signup

import com.android.shopapp.entity.register.RegisterRequest
import com.android.shopapp.entity.register.RegisterResponse
import retrofit2.Response

interface SignUpRepository {
    suspend fun signUp(signUp: RegisterRequest): Response<RegisterResponse>

}
