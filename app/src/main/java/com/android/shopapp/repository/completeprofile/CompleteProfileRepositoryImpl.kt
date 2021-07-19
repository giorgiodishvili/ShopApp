package com.android.shopapp.repository.completeprofile

import com.android.shopapp.entity.CompleteProfileStatusResponse
import com.android.shopapp.entity.ProfileCompleted
import com.android.shopapp.network.ApiService
import retrofit2.Response
import java.io.File
import javax.inject.Inject

class CompleteProfileRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    CompleteProfileRepository {

    override suspend fun completeProfile(): Response<ProfileCompleted> = apiService.completeProfile(1,"","","","","","",
        File("BLA.jpg")
    )
}

