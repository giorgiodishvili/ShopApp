package com.android.shopapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
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
        drawerAdapter = DrawerAdapter(
            listOf(
                DrawerItem(
                    R.id.action_logInFragment_to_homeFragment,
                    getString(R.string.my_profile)
                ),
                DrawerItem(R.id.action_logInFragment_to_homeFragment, getString(R.string.my_posts)),
                DrawerItem(R.id.action_logInFragment_to_homeFragment, getString(R.string.about)),
                DrawerItem(
                    R.id.action_logInFragment_to_homeFragment, getString(
                        R.string.my_cart
                    )
                )
            )
        )

        binding.drawerRecycler.adapter = drawerAdapter
        binding.drawerRecycler.layoutManager = LinearLayoutManager(requireContext())
        drawerAdapter.drawerItemOnClickListener = {
                requireActivity().supportFragmentManager.findFragmentById(R.id.nav_host_fragment_home_fragment) as NavHostFragment
        }
        initBottomNav()

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
        //Initialize Bottom Navigation View.
        //Initialize Bottom Navigation View.
        val navView: BottomNavigationView = binding.bottomNavigation

        //Pass the ID's of Different destinations

        //Pass the ID's of Different destinations
        val appBarConfiguration = AppBarConfiguration.Builder(
            R.id.homeFragment,
            R.id.favouriteFragment,
            R.id.myWalletFragment,
            R.id.trackOrdersFragment
        )
            .build()

        //Initialize NavController.

        //Initialize NavController.
        val navController: NavController = Navigation.findNavController(requireActivity(), binding.navHostFragmentHomeFragment.id)
        NavigationUI.setupWithNavController(navView, navController)
    }

}