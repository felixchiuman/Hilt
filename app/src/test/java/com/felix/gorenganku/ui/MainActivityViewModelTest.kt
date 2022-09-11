package com.felix.gorenganku.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.felix.gorenganku.data.api.model.category.GetCategoryListResponse
import com.felix.gorenganku.data.api.model.list.GetFeedsListResponse
import com.felix.gorenganku.data.repository.Repository
import com.felix.gorenganku.data.rule.MainCoroutineRule
import com.felix.gorenganku.ui.home.MainActivityViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mockito
import org.mockito.kotlin.given
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import retrofit2.Response

@OptIn(ExperimentalCoroutinesApi::class)
class TrendingViewModelTest {

    private lateinit var viewModel: MainActivityViewModel
    private lateinit var repository: Repository

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        repository = mock()
        viewModel = MainActivityViewModel(repository)
    }

    @Test
    fun getFavorite()= runTest {
        val favoriteResponse = mock<Response<GetFeedsListResponse>>()

        given(repository.getList()).willReturn(favoriteResponse)

        viewModel.getAllFavorite()

        advanceUntilIdle()

        Mockito.verify(repository, times(1)).getList()
        Assert.assertNotNull(viewModel.dataFavorite.value?.status)
        Assert.assertEquals(viewModel.dataFavorite.value?.data, favoriteResponse)
    }

    @Test
    fun getDetail()= runTest {
        val detailResponse = mock<Response<GetFeedsListResponse>>()

        given(repository.getListDetail()).willReturn(detailResponse)

        viewModel.getAllDetail()

        advanceUntilIdle()

        Mockito.verify(repository, times(1)).getListDetail()
        Assert.assertNotNull(viewModel.dataDetail.value?.status)
        Assert.assertEquals(viewModel.dataDetail.value?.data, detailResponse)
    }

    @Test
    fun getCategory()= runTest {
        val categoryResponse = mock<Response<GetCategoryListResponse>>()

        given(repository.getCategories()).willReturn(categoryResponse)

        viewModel.getAllCategory()

        advanceUntilIdle()

        Mockito.verify(repository, times(1)).getCategories()
        Assert.assertNotNull(viewModel.categories.value?.status)
        Assert.assertEquals(viewModel.categories.value?.data, categoryResponse)
    }
}