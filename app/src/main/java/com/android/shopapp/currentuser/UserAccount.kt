package com.android.shopapp.currentuser

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserAccount @Inject constructor(@ApplicationContext context: Context) {

    companion object {
        const val HAS_SESSION = "HAS_SESSION"
        const val TOKEN = "TOKEN"
        const val USER_ID = "USER_ID"
    }

    private val sharedPreference: SharedPreferences by lazy {
        context.getSharedPreferences("user_data", Context.MODE_PRIVATE)
    }

    fun hasSession(): Boolean {
        return sharedPreference.getBoolean(HAS_SESSION, false)
    }


    fun saveSession(session: Boolean) {
        sharedPreference.edit().putBoolean(HAS_SESSION, session).apply()
    }

    fun saveToken(token: String) {
        sharedPreference.edit().putString(TOKEN, token).apply()
    }

    fun token() = sharedPreference.getString(TOKEN, "")

    fun saveUserId(userId:Int) = sharedPreference.edit().putInt(USER_ID,userId).apply()

    fun getUserId() = sharedPreference.getInt(USER_ID, -1)
}