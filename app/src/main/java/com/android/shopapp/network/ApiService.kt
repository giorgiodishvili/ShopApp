package com.android.shopapp.network

import com.android.shopapp.entity.CompleteProfileStatusResponse
import com.android.shopapp.entity.Post
import com.android.shopapp.entity.ProfileCompleted
import com.android.shopapp.entity.login.LogInResponse
import com.android.shopapp.entity.register.RegisterRequest
import com.android.shopapp.entity.register.RegisterResponse
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.*
import java.io.File

interface ApiService {

    @POST("/login")
    @FormUrlEncoded
    suspend fun login(@Field("email") email: String,@Field("password") password: String): Response<LogInResponse>

    @POST("/register")
    suspend fun register(@Body register: RegisterRequest): Response<RegisterResponse>

    @GET("/posts")
    suspend fun getPosts(): Response<List<Post>>

    @POST("/profile")
    @FormUrlEncoded
    suspend fun completeProfileCheck(@Field("user_id") userId:Int ): Response<CompleteProfileStatusResponse>

    @POST("/complete-profile")
    @Multipart
    suspend fun completeProfile(@Part("user_id") userId:Int
                                ,@Part("address") address:String
                                ,@Part("card_number") cardNumber:String
                                ,@Part("card_holder_name") cardHolderName:String
                                ,@Part("expiry_date") expiry:String
                                ,@Part("security_code") security:String
                                ,@Part("floor_apartment") floorApartment:String
                                ,@Part("file") file:MultipartBody.Part
    ): Response<ProfileCompleted>


}