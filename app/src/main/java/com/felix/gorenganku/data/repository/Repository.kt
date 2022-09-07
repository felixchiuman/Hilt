package com.felix.gorenganku.data.repository

import com.felix.gorenganku.data.api.service.ApiHelper

class Repository(private val apiHelper: ApiHelper) {
    suspend fun getList() = apiHelper.getList()
}