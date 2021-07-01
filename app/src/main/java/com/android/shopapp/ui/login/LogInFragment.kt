package com.android.shopapp.ui.login

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.android.football.base.BaseFragment
import com.android.shopapp.databinding.LogInFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LogInFragment : BaseFragment<LogInFragmentBinding>(LogInFragmentBinding::inflate) {
    private val logInViewModel: LogInViewModel by viewModels()

    override fun start(inflater: LayoutInflater, container: ViewGroup?) {

    }


}