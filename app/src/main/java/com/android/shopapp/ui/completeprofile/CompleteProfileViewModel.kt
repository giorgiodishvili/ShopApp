package com.android.shopapp.ui.completeprofile

import androidx.lifecycle.ViewModel
import com.android.shopapp.repository.completeprofile.CompleteProfileRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CompleteProfileViewModel @Inject constructor(private val completeProfileRepository: CompleteProfileRepository) :
    ViewModel() {


}