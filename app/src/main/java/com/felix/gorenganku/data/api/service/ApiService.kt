package com.felix.gorenganku.data.api.service

import com.felix.gorenganku.data.api.service.list.GetFeedsListResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("feeds/list?limit=24&start=0")
    suspend fun getList(): List<GetFeedsListResponse>
}