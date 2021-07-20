package com.android.shopapp.ui.trackorder

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.android.shopapp.R

class TrackOrdersFragment : Fragment() {

    companion object {
        fun newInstance() = TrackOrdersFragment()
    }

    private lateinit var viewModel: TrackOrdersViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.track_orders_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TrackOrdersViewModel::class.java)
        // TODO: Use the ViewModel
    }

}