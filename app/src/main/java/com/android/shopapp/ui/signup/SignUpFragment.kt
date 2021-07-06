package com.android.shopapp.ui.signup

import android.app.Dialog
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.android.football.base.BaseFragment
import com.android.shopapp.R
import com.android.shopapp.currentuser.UserAccount
import com.android.shopapp.databinding.SignUpFragmentBinding
import com.android.shopapp.entity.register.RegisterRequest
import com.android.shopapp.extensions.*
import com.android.shopapp.network.Resource
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SignUpFragment : BaseFragment<SignUpFragmentBinding>(SignUpFragmentBinding::inflate) {

    private val signUpViewModel: SignUpViewModel by viewModels()

    override fun start(inflater: LayoutInflater, container: ViewGroup?) {
        binding.signUpBtn.signInBtn.setText(R.string.sign_up)
        binding.emailITXT.isEndIconVisible = false
        setSpannedString()
        init()
    }

    private fun setSpannedString() {

        //TODO ADD COLOR
        binding.signIn.setSpannedString(
            arrayOf(
                "Aleady Have Account? ",
                "Sign in ",
                "here"
            ),
            arrayOf(R.color.black,R.color.main_grey,R.color.black)
        )
    }
    private fun init(){
        binding.signUpBtn.signInBtn.setOnClickListener {
            passedInfoCheck()
        }

        binding.signIn.setOnClickListener {
            findNavController().navigate(R.id.action_signUpFragment_to_logInFragment)
        }

        binding.emailET.doOnTextChanged { text, _, _, _ ->
            emailValidator(text.toString())
        }
    }

    private fun emailValidator(text: String){
        binding.emailITXT.isEndIconVisible = text.isEmail()
    }

    private fun passedInfoCheck(){
        val register = RegisterRequest(binding.emailET.text?.trim().toString(),
            binding.passwordET.text?.trim().toString(),binding.fullNameET.text?.trim().toString())
        if (register.email.isNotEmpty() && register.password.isNotEmpty() && !binding.confirmPasswordET.text.isNullOrBlank() && register.fullName.isNotEmpty()){
            if (register.email.isEmail()){
                if(register.password == binding.confirmPasswordET.text.toString().trim()){
                    signUpViewModel.register(register)
                    observe()
                }
            }else{
                showDialog("Email Format is Incorrect")
            }
        }else{
            showDialog("Please Fill in All the fields")
        }
    }

    private fun showDialog(message: String){
        val dialog = Dialog(requireContext())
        dialog.setUp(R.layout.dialog_layout)
        dialog.findViewById<TextView>(R.id.description).text = message
        dialog.findViewById<Button>(R.id.close).setOnClickListener {
            dialog.cancel()
        }
        dialog.show()
    }

    private fun observe(){
        signUpViewModel.signUpData.observe(viewLifecycleOwner, {
            binding.progressBar.hideIf(it.status == Resource.Status.LOADING)
            when(it.status){
                Resource.Status.SUCCESS -> {
                    findNavController().navigate(R.id.action_signUpFragment_to_logInFragment)
                }
                Resource.Status.ERROR -> {
                    showDialog(it.message!!)
                }
                else -> {}
            }
        })
    }


}