package com.felix.gorenganku.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.felix.gorenganku.data.api.service.list.GetFeedsListResponse
import com.felix.gorenganku.data.repository.Repository
import com.felix.gorenganku.resource.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _dataFavorite = MutableLiveData<Resource<List<GetFeedsListResponse.Feed.Content.Details>>>()
    val dataFavorite: LiveData<Resource<List<GetFeedsListResponse.Feed.Content.Details>>> get() = _dataFavorite

    fun getAllFavorite(){
        viewModelScope.launch {
            _dataFavorite.postValue(Resource.loading())
            try {
                _dataFavorite.postValue(Resource.success(repository.getList()))
            }catch (e: Exception){
                _dataFavorite.postValue(Resource.error(e.message.toString()))
            }
        }
    }
}