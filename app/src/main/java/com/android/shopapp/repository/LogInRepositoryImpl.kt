package com.android.shopapp.repository

import com.android.shopapp.entity.login.LogInRequest
import com.android.shopapp.entity.login.LogInResponse
import com.android.shopapp.network.ApiService
import retrofit2.Response
import javax.inject.Inject


class LogInRepositoryImpl @Inject constructor(private val apiService: ApiService): LogInRepository {


    override suspend fun logIn(login: LogInRequest): Response<LogInResponse>  = apiService.login(login)

}