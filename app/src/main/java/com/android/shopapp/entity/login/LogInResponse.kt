package com.android.shopapp.entity.login

import com.google.gson.annotations.SerializedName

data class LogInResponse(
    val token: String,
    @SerializedName("user_id")
    val userId: Int
)