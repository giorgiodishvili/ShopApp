package com.android.shopapp.ui.home

import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.football.base.BaseFragment
import com.android.shopapp.R
import com.android.shopapp.adapter.DrawerAdapter
import com.android.shopapp.databinding.HomeFragmentBinding
import com.android.shopapp.entity.DrawerItem


class HomeFragment : BaseFragment<HomeFragmentBinding>(HomeFragmentBinding::inflate) {

    private lateinit var drawerAdapter: DrawerAdapter
    override fun start(inflater: LayoutInflater, container: ViewGroup?) {
        initBottomNav()
        initDrawer()
    }

    private fun initDrawer() {
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

        binding.drawerRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.drawerRecycler.adapter = drawerAdapter
        drawerAdapter.drawerItemOnClickListener = {
            //                requireActivity().supportFragmentManager.findFragmentById(R.id.nav_host_fragment_home_fragment) as NavHostFragment
        }

        binding.menuBtn.setOnClickListener {
            if (!binding.drawerLayout.isDrawerOpen(Gravity.END)) {
                binding.drawerLayout.openDrawer(Gravity.END);
            } else {
                binding.drawerLayout.closeDrawer(Gravity.END);
            }
        }
    }

    private fun initBottomNav() {
        val navHostFragment =
            childFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavigation.setupWithNavController(navController)
    }


}