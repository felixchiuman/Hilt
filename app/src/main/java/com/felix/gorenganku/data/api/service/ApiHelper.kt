package com.felix.gorenganku.data.api.service

class ApiHelper(private val apiService: ApiService) {
    suspend fun  getList() = apiService.getList()
}