package com.android.shopapp.repository.completeprofile

import com.android.shopapp.entity.CompleteProfileStatusResponse
import com.android.shopapp.network.ApiService
import retrofit2.Response
import javax.inject.Inject

class CompleteProfileRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    CompleteProfileRepository {

//    //TODO fix this for multipart
//    override suspend fun completeProfile(): Response<ProfileCompleted> = apiService.completeProfile(1,"","","","","","",
//    )


    override suspend fun getCompleteProfileStatus(userId: Int): Response<CompleteProfileStatusResponse> =
        apiService.completeProfileCheck(userId)

}

