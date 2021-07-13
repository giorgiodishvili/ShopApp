package com.android.shopapp.ui.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.football.base.BaseFragment
import com.android.shopapp.R
import com.android.shopapp.databinding.HomeFragmentBinding
import com.android.shopapp.drawer.DrawerAdapter
import com.android.shopapp.entity.DrawerItem
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeFragment : BaseFragment<HomeFragmentBinding>(HomeFragmentBinding::inflate) {

    private lateinit var drawerAdapter: DrawerAdapter


    override fun start(inflater: LayoutInflater, container: ViewGroup?) {
        initBottomNav()
        drawerAdapter = DrawerAdapter(listOf(
            DrawerItem(R.id.action_logInFragment_to_homeFragment,getString(R.string.my_profile)),
            DrawerItem(R.id.action_logInFragment_to_homeFragment,getString(R.string.my_posts)),
            DrawerItem(R.id.action_logInFragment_to_homeFragment,getString(R.string.about)),
            DrawerItem(R.id.action_logInFragment_to_homeFragment,getString(R.string.my_cart
            ))))

        binding.drawerRecycler.adapter = drawerAdapter
        binding.drawerRecycler.layoutManager = LinearLayoutManager(requireContext())
        drawerAdapter.drawerItemOnClickListener = {
//            findNavController().navigate(it)
            val navController = requireActivity().supportFragmentManager.findFragmentById(R.id.nav_host_fragment_home_fragment) as NavHostFragment
        }

//        binding.bottomNavigation.OnNavigationItemSelectedListener { item ->
//            when(item.itemId) {
//                R.id. -> {
//                    // Respond to navigation item 1 click
//                    true
//                }
//                R.id.item2 -> {
//                    // Respond to navigation item 2 click
//                    true
//                }
//                else -> false
//            }
//        }
    }

    private fun initBottomNav() {
        val navController =
            childFragmentManager.findFragmentById(R.id.nav_host_fragment_home_fragment) as NavHostFragment
        binding.bottomNavigation.setupWithNavController(navController.navController)
    }

}