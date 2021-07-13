package com.android.shopapp.ui.wall

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.shopapp.entity.Post
import com.android.shopapp.entity.register.RegisterRequest
import com.android.shopapp.network.Resource
import com.android.shopapp.repository.posts.PostsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WallViewModel @Inject constructor(private val postsRepository: PostsRepository) : ViewModel() {
    private val _postLiveData = MutableLiveData<Resource<List<Post>>>()

    val postLiveData: LiveData<Resource<List<Post>>>
        get() = _postLiveData

    fun register(register: RegisterRequest) =
        viewModelScope.launch {
            _postLiveData.postValue(Resource.loading())
            postsRepository.getPosts().let {
                if (it.isSuccessful) {
                    _postLiveData.postValue(Resource.success(it.body()!!))
                } else {
                    _postLiveData.postValue(Resource.error(it.message().toString()))
                }
            }
        }
}