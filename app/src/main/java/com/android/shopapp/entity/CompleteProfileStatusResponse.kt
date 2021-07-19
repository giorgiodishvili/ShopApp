package com.android.shopapp.entity

import com.google.gson.annotations.SerializedName

data class CompleteProfileStatusResponse(
    val email: String,
    @SerializedName("full_name")
    val fullName: String,
    @SerializedName("profile-completed")
    val profileCompleted: Boolean,
    val address: String?,
    val card_holder_name: String?,
    val card_number: String?,
    val expiry_date: String?,
    val floor_apartment: String?,
    val profile_url: String?,
    val security_code: String?
)