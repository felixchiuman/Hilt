package com.felix.gorenganku.data.repository

import com.felix.gorenganku.data.api.model.category.GetCategoryListResponse
import com.felix.gorenganku.data.api.model.list.GetFeedsListResponse
import com.felix.gorenganku.data.api.service.ApiHelper
import com.felix.gorenganku.data.api.service.ApiService
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import retrofit2.Response

class RepositoryTest {

    //variable yg diperlukan
    private lateinit var apiService: ApiService
    private lateinit var apiHelper: ApiHelper
    private lateinit var repository: Repository

    @Before
    fun setUp(){
        apiService = mockk()
        apiHelper = mockk()

        repository = Repository(apiHelper)
    }

    //sintaks nya untuk mengambil data dari apiHelper
    @Test
    fun getCategory(): Unit = runBlocking {
        val categoryResponse = mockk<Response<GetCategoryListResponse>>()

        every{
            runBlocking {
                apiHelper.getCategories()
            }
        } returns categoryResponse
//system under test
        repository.getCategories()
//then -> apakah data pada var categoryResp sudah cocok dengan helper getcategory
        verify {
            runBlocking {
                apiHelper.getCategories()
            }
        }
    }

    @Test
    fun getList(): Unit = runBlocking {
        val getList = mockk<Response<GetFeedsListResponse>>()

        every{
            runBlocking {
                apiHelper.getList()
            }
        } returns getList

        repository.getList()

        verify {
            runBlocking {
                apiHelper.getList()
            }
        }
    }

    @Test
    fun getListDetail(): Unit = runBlocking {
        val getListDetail = mockk<Response<GetFeedsListResponse>>()

        every{
            runBlocking {
                apiHelper.getListDetail()
            }
        } returns getListDetail

        repository.getListDetail()

        verify {
            runBlocking {
                apiHelper.getListDetail()
            }
        }
    }
}