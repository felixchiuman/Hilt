package com.felix.gorenganku.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.felix.gorenganku.BuildConfig
import com.felix.gorenganku.data.api.service.ApiHelper
import com.felix.gorenganku.data.api.service.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

private const val BASE_URL = "https://yummly2.p.rapidapi.com/"
private val apiKey = BuildConfig.API_KEY

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Singleton
    @Provides
    fun provideChuckerInterceptor(
        @ApplicationContext context: Context
    ): ChuckerInterceptor {
        return ChuckerInterceptor.Builder(context)
            .collector(ChuckerCollector(context))
            .maxContentLength(250000L)
            .redactHeaders(emptySet())
            .alwaysReadResponseBody(false)
            .build()
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        chuckerInterceptor: ChuckerInterceptor,
        headerInterceptor: Interceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(headerInterceptor)
//            .addInterceptor{chain ->
//                val original = chain.request()
//                val url = original.url.newBuilder()
////                    .addQueryParameter("X-RapidAPI-Key", apiKey)
////                    .addQueryParameter("X-RapidAPI-Host", "yummly2.p.rapidapi.com")
//                    .addQueryParameter("limit","24")
//                    .addQueryParameter("start","0")
//                    .build()
//
//                val request = original.newBuilder()
//                    .url(url)
//                    .build()
//                chain.proceed(request)
//            }
            .addInterceptor(loggingInterceptor)
            .addInterceptor(chuckerInterceptor)
            .connectTimeout(60000, TimeUnit.MILLISECONDS)
            .readTimeout(60000, TimeUnit.MILLISECONDS)
            .writeTimeout(60000, TimeUnit.MILLISECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun getInterceptor(): Interceptor {
        return Interceptor {
            val request = it.request().newBuilder()
                request.addHeader("X-RapidAPI-Key", apiKey)
                request.addHeader("X-RapidAPI-Host", "yummly2.p.rapidapi.com")
            it.proceed(request.build())
        }
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create()
    }

    @Singleton
    @Provides
    fun provideApiHelper(apiService: ApiService): ApiHelper {
        return ApiHelper(apiService)
    }
}