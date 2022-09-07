package com.felix.gorenganku.data.api.service

class ApiHelper(val apiService: ApiService) {
    suspend fun  getList() = apiService.getList()
}