package com.android.shopapp.ui.completeprofile

import android.Manifest
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.android.football.base.BaseFragment
import com.android.shopapp.databinding.CompleteProfileFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CompleteProfileFragment :
    BaseFragment<CompleteProfileFragmentBinding>(CompleteProfileFragmentBinding::inflate) {
    private val completeProfileViewModel: ViewModel by viewModels()
    private var fileURL : Uri? = null
    override fun start(inflater: LayoutInflater, container: ViewGroup?) {
        setListeners()
    }

    private fun setListeners() {
        binding.profile.setOnClickListener {
            if (hasCameraPermissions() && hasReadExternalPersmission() && hasWriteStoragePermission()) {
                openCamera()
            }else{
                requestPermissionResults
            }
        }
    }


    private val requestPermissionResults =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {
            if (it[Manifest.permission.CAMERA] == true && it[Manifest.permission.WRITE_EXTERNAL_STORAGE] == true)run {
            openCamera()
        }
        }

    private fun openCamera() {

    }


}