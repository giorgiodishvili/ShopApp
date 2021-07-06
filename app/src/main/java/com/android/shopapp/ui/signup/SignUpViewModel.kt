package com.android.shopapp.ui.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.shopapp.entity.register.RegisterRequest
import com.android.shopapp.entity.register.RegisterResponse
import com.android.shopapp.network.Resource
import com.android.shopapp.repository.SignUpRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(private val signupRepo: SignUpRepository) : ViewModel() {
    private val _signUpLiveData = MutableLiveData<Resource<RegisterResponse>>()

    val signUpData: LiveData<Resource<RegisterResponse>>
        get() = _signUpLiveData

    suspend fun login(register: RegisterRequest) =
        viewModelScope.launch {
            _signUpLiveData.postValue(Resource.loading())
            signupRepo.signUp(register).let {
                if (it.isSuccessful) {
                    _signUpLiveData.postValue(Resource.success(it.body()!!))
                } else {
                    _signUpLiveData.postValue(Resource.error(it.errorBody().toString()))
                }
            }
        }


}