package com.android.shopapp.ui.wallet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.android.shopapp.R

class MyWalletFragment : Fragment() {

    companion object {
        fun newInstance() = MyWalletFragment()
    }

    private lateinit var viewModel: MyWalletViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.my_wallet_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MyWalletViewModel::class.java)
        // TODO: Use the ViewModel
    }

}