package com.example.ecommerceconcept.modules

import android.content.Context
import androidx.room.Room
import com.example.ecommerceconcept.db.retroData.MainRemoteData
import com.example.ecommerceconcept.db.retroData.MainService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

//@Module
////зависимости доступны в контексте приложения
//@InstallIn(SingletonComponent::class)
//object AppModule {
//
//    @Singleton
//    @Provides
//    fun provideTelDatabase(
//        @ApplicationContext app: Context
//    ) = Room.databaseBuilder(
//        app,
//        TelDatabase::class.java,
//        "tels_db"
//    ).build()
//
//    @Singleton
//    @Provides
//    fun provideTelDao(db: TelDatabase) = db.getTelDao()
//}

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
    fun provideRetrofit(BASE_URL : String) : Retrofit = Retrofit.Builder()
        .client(client())
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    @Provides
    @Singleton
    fun provideMainService(retrofit : Retrofit) : MainService = retrofit.create(MainService::class.java)

    @Provides
    @Singleton
    fun provideMainRemoteData(mainService : MainService) : MainRemoteData = MainRemoteData(mainService)
}