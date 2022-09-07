package com.felix.gorenganku.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.felix.gorenganku.data.api.model.list.GetFeedsListResponse
import com.felix.gorenganku.data.repository.Repository
import com.felix.gorenganku.resource.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _dataFavorite = MutableLiveData<Resource<Response<GetFeedsListResponse>>>()
    val dataFavorite: LiveData<Resource<Response<GetFeedsListResponse>>> get() = _dataFavorite

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