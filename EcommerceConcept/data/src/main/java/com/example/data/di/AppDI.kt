package com.example.data.di

import com.example.data.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton



@Module
@InstallIn(SingletonComponent::class)
object RetroModule {

    fun interceptor(): HttpLoggingInterceptor {
        val interceptorobj = HttpLoggingInterceptor()
        interceptorobj.level = HttpLoggingInterceptor.Level.HEADERS

        return interceptorobj
    }

    fun client(): OkHttpClient {
        val clientobj = OkHttpClient().newBuilder().addInterceptor(interceptor()).build()
        return clientobj
    }

    @Provides
    fun providesBaseUrl(): String = "http://10.0.2.2:8080/"

    @Provides
    @Singleton
    fun provideRetrofit(BASE_URL: String): Retrofit = Retrofit.Builder()
        .client(client())
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    @Provides
    @Singleton
    fun provideMainService(retrofit: Retrofit): MainRepository =
        retrofit.create(MainRepository::class.java)
}