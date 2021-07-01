package com.android.shopapp.repository

import com.android.shopapp.entity.login.LogInRequest
import com.android.shopapp.entity.login.LogInResponse
import retrofit2.Response

interface LogInRepository {

    suspend fun logIn(login: LogInRequest): Response<LogInResponse>
}