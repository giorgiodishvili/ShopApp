package com.android.shopapp.ui.splash

import android.animation.Animator
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.android.football.base.BaseFragment
import com.android.shopapp.R
import com.android.shopapp.currentuser.UserAccount
import com.android.shopapp.databinding.SplashScreenFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class SplashScreenFragment :
    BaseFragment<SplashScreenFragmentBinding>(SplashScreenFragmentBinding::inflate) {

    @Inject
    public lateinit var userAccount: UserAccount


    override fun start(inflater: LayoutInflater, container: ViewGroup?) {

        binding.lottieMain.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator?) {
            }

            override fun onAnimationEnd(animation: Animator) {
                try {
                    checkForRememberMeUser()
                } catch (ex: Exception) {
                    ex.toString()
                }
            }

            override fun onAnimationCancel(animation: Animator?) {
            }

            override fun onAnimationRepeat(animation: Animator?) {
            }
        })
    }


    private fun checkForRememberMeUser() {
        if (userAccount.hasSession()) {
            findNavController().navigate(R.id.action_splashScreenFragment_to_homeFragment)
        }else{
            findNavController().navigate(R.id.action_splashScreenFragment_to_logInFragment)
        }
    }
}