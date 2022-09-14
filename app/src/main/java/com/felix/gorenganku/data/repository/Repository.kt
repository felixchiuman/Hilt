package com.felix.gorenganku.data.repository

import com.felix.gorenganku.data.api.service.ApiService

class Repository(private val apiService: ApiService) {
    suspend fun getList() = apiService.getList()

    suspend fun getListDetail() = apiService.getListDetail()

    suspend fun getCategories() = apiService.getCategories()
}