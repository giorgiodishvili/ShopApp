package com.android.shopapp.entity.login

import com.google.gson.annotations.SerializedName

data class LogInResponse(private val token: String,
                         @SerializedName("user_id")
                         private val userId: Int)