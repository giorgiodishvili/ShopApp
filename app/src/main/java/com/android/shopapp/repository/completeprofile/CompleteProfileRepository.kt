package com.android.shopapp.repository.completeprofile

import com.android.shopapp.entity.CompleteProfileStatusResponse
import com.android.shopapp.entity.ProfileCompleted
import retrofit2.Response

interface CompleteProfileRepository {

    suspend fun completeProfile(): Response<ProfileCompleted>

}