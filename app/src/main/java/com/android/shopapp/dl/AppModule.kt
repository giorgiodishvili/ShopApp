package com.android.shopapp.dl

import com.android.shopapp.BuildConfig
import com.android.shopapp.network.ApiService
import com.android.shopapp.repository.completeprofile.CompleteProfileRepository
import com.android.shopapp.repository.completeprofile.CompleteProfileRepositoryImpl
import com.android.shopapp.repository.login.LogInRepository
import com.android.shopapp.repository.login.LogInRepositoryImpl
import com.android.shopapp.repository.posts.PostsRepository
import com.android.shopapp.repository.posts.PostsRepositoryImpl
import com.android.shopapp.repository.signup.SignUpRepository
import com.android.shopapp.repository.signup.SignUpRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideBaseUrl() = "https://ktorhighsteaks.herokuapp.com/"

    @Singleton
    @Provides
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    } else {
        OkHttpClient
            .Builder()
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, BASE_URL: String): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun provideService(retrofit: Retrofit) = retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideLoginRepository(loginRepo: LogInRepositoryImpl): LogInRepository = loginRepo

    @Provides
    @Singleton
    fun provideSignUpRepository(signupRepo: SignUpRepositoryImpl): SignUpRepository = signupRepo


    @Provides
    @Singleton
    fun providesPostsRepo(postsRepo: PostsRepositoryImpl): PostsRepository = postsRepo


    @Provides
    @Singleton
    fun completeProfileRepo(profileRepo: CompleteProfileRepositoryImpl): CompleteProfileRepository =
        profileRepo

}