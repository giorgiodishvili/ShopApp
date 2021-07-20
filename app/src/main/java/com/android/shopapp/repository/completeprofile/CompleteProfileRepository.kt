package com.android.shopapp.repository.completeprofile

import com.android.shopapp.entity.CompleteProfileStatusResponse
import retrofit2.Response

interface CompleteProfileRepository {

//    suspend fun completeProfile(): Response<ProfileCompleted>

    suspend fun getCompleteProfileStatus(userId: Int): Response<CompleteProfileStatusResponse>


}