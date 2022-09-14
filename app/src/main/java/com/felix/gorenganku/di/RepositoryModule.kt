package com.felix.gorenganku.di

import com.felix.gorenganku.data.api.service.ApiService
import com.felix.gorenganku.data.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @ViewModelScoped
    @Provides
    fun provideRepository(apiService: ApiService) = Repository(apiService)
}