package com.android.shopapp.entity.login

import com.google.gson.annotations.SerializedName

data class LogInRequest(
    val email: String,
    @SerializedName("password")
    val password: String,
)