package com.android.shopapp.ui.login

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
import com.android.shopapp.databinding.LogInFragmentBinding
import com.android.shopapp.entity.login.LogInRequest
import com.android.shopapp.extensions.*
import com.android.shopapp.network.Resource
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LogInFragment : BaseFragment<LogInFragmentBinding>(LogInFragmentBinding::inflate) {
    private val logInViewModel: LogInViewModel by viewModels()

    override fun start(inflater: LayoutInflater, container: ViewGroup?) {
        binding.emailITXT.isEndIconVisible = false
        checkUserSession()
        setSpannedString()
        init()
    }

    @Inject
    private lateinit var userAccount: UserAccount

    private fun checkUserSession(){
        val session = userAccount.hasSession()
        if (session){
            findNavController().navigate(R.id.action_logInFragment_to_homeFragment)
        }
    }

    private fun setSpannedString() {

        //TODO ADD COLOR
        binding.signUp.setSpannedString(
            arrayOf(
                "New user? ",
                "Sign up",
                "here"
            ),
            arrayOf()
        )
    }
    private fun init(){
        binding.signInBtn.signInBtn.setOnClickListener {
            passedInfoCheck()
        }

        binding.signUp.setOnClickListener {
            findNavController().navigate(R.id.action_logInFragment_to_signUpFragment)
        }

        binding.emailET.doOnTextChanged { text, _, _, _ ->
            emailValidator(text.toString())
        }
    }

    private fun emailValidator(text: String){
        binding.emailITXT.isEndIconVisible = text.isEmail()
    }

    private fun passedInfoCheck(){
        val login = LogInRequest(binding.emailET.text?.trim().toString(),
            binding.emailET.text?.trim().toString())
        if (login.email.isNotEmpty() && login.password.isNotEmpty()){
            if (login.email.isEmail()){
                logInViewModel.login(login)
                observe()
            }else{
                showDialog("Email Format is Incorrect")
            }
        }else{
            showDialog("Please Fill in All the fields")
        }
    }

    private fun showDialog(desc: String){
        val dialog = Dialog(requireContext())
        dialog.setUp(R.layout.dialog_layout)
        dialog.findViewById<TextView>(R.id.description).text = desc
        dialog.findViewById<Button>(R.id.close).setOnClickListener {
            dialog.cancel()
        }
        dialog.show()
    }

    private fun observe(){
        logInViewModel.res.observe(viewLifecycleOwner, {
            binding.progressBar.hideIf(it.status == Resource.Status.LOADING)
            when(it.status){
                Resource.Status.SUCCESS -> {
                    logInViewModel.saveSession(binding.rememberMe.isChecked)
                    logInViewModel.saveToken(it.data!!.token)
                    findNavController().navigate(R.id.action_logInFragment_to_homeFragment)
                }
                Resource.Status.ERROR -> {
                    Toast.makeText(requireContext(), "${it.message}", Toast.LENGTH_SHORT).show()
                }
                Resource.Status.LOADING -> {
                    binding.progressBar.hide()
                }
            }
        })
    }


}