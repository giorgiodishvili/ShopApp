package com.android.shopapp.ui.wall

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.football.base.BaseFragment
import com.android.shopapp.databinding.WallFragmentBinding
import com.android.shopapp.drawer.PostRecyclerViewAdapter
import com.android.shopapp.entity.Post
import com.android.shopapp.network.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WallFragment : BaseFragment<WallFragmentBinding>(WallFragmentBinding::inflate) {
    private val wallViewModel: WallViewModel by viewModels()
    private lateinit var adapter: PostRecyclerViewAdapter


    override fun start(inflater: LayoutInflater, container: ViewGroup?) {
        wallViewModel.getPosts()
        observe()
    }

    private fun observe() {
        wallViewModel.postLiveData.observe(viewLifecycleOwner, { resource ->
            when (resource.status) {
                Resource.Status.SUCCESS -> {
                    initRecycler(resource.data)
                }
                Resource.Status.ERROR -> {
                    Log.i("shjowDialog", resource.toString())
                }
                else -> {
                }
            }
        })
    }

    private fun initRecycler(data: List<Post>?) {
        adapter = PostRecyclerViewAdapter(data!!)
        binding.wallPostsRV.adapter = adapter
        binding.wallPostsRV.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL, false
        )
    }


}