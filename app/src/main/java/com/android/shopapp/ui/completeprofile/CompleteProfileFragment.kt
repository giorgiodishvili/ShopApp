package com.android.shopapp.ui.completeprofile

import android.Manifest
import android.app.Activity.RESULT_OK
import android.content.ContentValues
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
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
    private var fileURL: Uri? = null

    companion object {

        private const val PERMISSION_CODE = 1000
        private const val IMAGE_CAPTURE_CODE = 1001
    }

    override fun start(inflater: LayoutInflater, container: ViewGroup?) {
        setListeners()
    }

    private fun setListeners() {
        binding.profilePicIV.setOnClickListener {
            if (hasCameraPermissions() && hasReadExternalPersmission() && hasWriteStoragePermission()) {
                openCamera()
            } else {
                requestPermission(requestPermissionResults)
            }
        }
    }


    private val requestPermissionResults =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {
            if (it[Manifest.permission.CAMERA] == true && it[Manifest.permission.WRITE_EXTERNAL_STORAGE] == true) run {
                openCamera()
            }
        }

    private fun openCamera() {
        val values = ContentValues()
        values.put(MediaStore.Images.Media.TITLE, "New Picture")
        values.put(MediaStore.Images.Media.DESCRIPTION, "From the Camera")
        fileURL =
            requireActivity().contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)
        //Camera intent
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileURL)
        startActivityForResult(cameraIntent, IMAGE_CAPTURE_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        //called when image was captured from camera
        if (resultCode == RESULT_OK) {
            //set the image captured to our ImageView
            binding.profilePicIV.setImageURI(fileURL)
        }
    }

}