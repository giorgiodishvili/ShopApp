package com.android.shopapp.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.shopapp.currentuser.UserAccount
import com.android.shopapp.entity.CompleteProfileStatusResponse
import com.android.shopapp.entity.login.LogInRequest
import com.android.shopapp.entity.login.LogInResponse
import com.android.shopapp.network.Resource
import com.android.shopapp.repository.completeprofile.CompleteProfileRepository
import com.android.shopapp.repository.login.LogInRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LogInViewModel @Inject constructor(
    private val logInRepo: LogInRepository,
    private val completeProfileRepository: CompleteProfileRepository,
    private val userData: UserAccount
) : ViewModel() {

    private val _res = MutableLiveData<Resource<LogInResponse>>()

    val res: LiveData<Resource<LogInResponse>>
        get() = _res

    private val _completeProfileStatus = MutableLiveData<Resource<CompleteProfileStatusResponse>>()

    val completeProfileStatus: LiveData<Resource<CompleteProfileStatusResponse>>
        get() = _completeProfileStatus

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

    fun saveSession(inSession: Boolean) {
        userData.saveSession(inSession)
    }

    fun saveToken(token: String) {
        userData.saveToken(token)
    }

    fun saveUserId(userId: Int) {
        userData.saveUserId(userId)
    }

    fun checkStatus() =
        viewModelScope.launch {
            _completeProfileStatus.postValue(Resource.loading())
            completeProfileRepository.getCompleteProfileStatus(userData.getUserId()).let {
                if (it.isSuccessful) {
                    _completeProfileStatus.postValue(Resource.success(it.body()!!))
                } else {
                    _completeProfileStatus.postValue(Resource.error(it.message().toString()))
                }
            }
        }


}