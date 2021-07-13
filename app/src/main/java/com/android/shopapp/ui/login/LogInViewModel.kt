package com.android.shopapp.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.shopapp.currentuser.UserAccount
import com.android.shopapp.entity.login.LogInRequest
import com.android.shopapp.entity.login.LogInResponse
import com.android.shopapp.network.Resource
import com.android.shopapp.repository.login.LogInRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LogInViewModel @Inject constructor(private val logInRepo: LogInRepository, val userData: UserAccount) : ViewModel() {

    private val _res = MutableLiveData<Resource<LogInResponse>>()

    val res: LiveData<Resource<LogInResponse>>
        get() = _res

    fun login(login: LogInRequest) =
        viewModelScope.launch {
            _res.postValue(Resource.loading())
            logInRepo.logIn(login).let {
                if (it.isSuccessful) {
                    _res.postValue(Resource.success(it.body()!!))
                } else {
                    _res.postValue(Resource.error(it.message().toString()))
                }
            }
        }

    fun saveSession(inSession: Boolean){
        userData.saveSession(inSession)
    }

    fun saveToken(token: String){
        userData.saveToken(token)
    }
}