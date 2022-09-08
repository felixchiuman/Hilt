package com.felix.gorenganku.data.api.service

class ApiHelper(private val apiService: ApiService) {
    suspend fun  getList() = apiService.getList()

    suspend fun getListDetail() = apiService.getListDetail()

    suspend fun getCategories() = apiService.getCategories()
}