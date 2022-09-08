package com.felix.gorenganku.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.felix.gorenganku.data.api.model.category.GetCategoryListResponse
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

    private val _dataDetail = MutableLiveData<Resource<Response<GetFeedsListResponse>>>()
    val dataDetail: LiveData<Resource<Response<GetFeedsListResponse>>> get() = _dataDetail

    fun getAllDetail(){
        viewModelScope.launch {
            _dataDetail.postValue(Resource.loading())
            try {
                _dataDetail.postValue(Resource.success(repository.getListDetail()))
            }catch (e: Exception){
                _dataDetail.postValue(Resource.error(e.message.toString()))
            }
        }
    }

    private val _categories = MutableLiveData<Resource<Response<GetCategoryListResponse>>>()
    val categories: LiveData<Resource<Response<GetCategoryListResponse>>> get() = _categories

    fun getAllCategory(){
        viewModelScope.launch {
            _categories.postValue(Resource.loading())
            try {
                _categories.postValue(Resource.success(repository.getCategories()))
            }catch (e: Exception){
                _categories.postValue(Resource.error(e.message.toString()))
            }
        }
    }
}