package com.android.shopapp.repository.signup

import com.android.shopapp.entity.register.RegisterRequest
import com.android.shopapp.network.ApiService
import javax.inject.Inject

class SignUpRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    SignUpRepository {
    override suspend fun signUp(signUp: RegisterRequest) =
        apiService.register(signUp.email, signUp.password, signUp.fullName)

}