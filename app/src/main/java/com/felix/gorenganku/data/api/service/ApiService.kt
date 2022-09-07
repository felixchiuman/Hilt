package com.felix.gorenganku.data.api.service

import com.felix.gorenganku.BuildConfig
import com.felix.gorenganku.data.api.service.list.GetFeedsListResponse
import retrofit2.Response
import retrofit2.http.GET

private val apiKey = BuildConfig.API_KEY

interface ApiService {
    @GET("feeds/list/")
    suspend fun getList(): List<GetFeedsListResponse>
}