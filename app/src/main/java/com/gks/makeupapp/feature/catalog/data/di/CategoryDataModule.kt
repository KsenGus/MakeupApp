package com.gks.makeupapp.feature.catalog.data.di

import android.content.Context
import androidx.room.Room
import api.MakeUpAPI
import com.gks.makeupapp.feature.catalog.data.CategoryDataRepository
import com.gks.makeupapp.feature.catalog.domain.CategoryRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class CategoryDataModule {
  @Binds
  abstract fun bindCategoriesRepository(dataRepository: CategoryDataRepository): CategoryRepository
}

@Module
@InstallIn(SingletonComponent::class)
data object MakeUpNetworkModule {
  @Singleton
  @Provides
  fun provideOkHttp(): OkHttpClient {
    return OkHttpClient.Builder()
      .connectTimeout(3, TimeUnit.MINUTES)
      .readTimeout(3, TimeUnit.MINUTES)
      .writeTimeout(3, TimeUnit.MINUTES)
      .apply {
        val loggingInterceptor = HttpLoggingInterceptor { message -> println(message) }
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        addNetworkInterceptor(loggingInterceptor)
      }
      .build()
  }

  @Provides
  fun provideJson(): Json {
    return Json {
      ignoreUnknownKeys = true
      encodeDefaults = true
      explicitNulls = false
    }
  }

  @Provides
  fun provideRetrofit(okHttpClient: OkHttpClient, json: Json): Retrofit {
    return Retrofit.Builder()
      .baseUrl("http://makeup-api.herokuapp.com/api/")
      .client(okHttpClient)
      .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
      .build()
  }

  @Provides
  fun provideMakeUpApi(retrofit: Retrofit): MakeUpAPI {
    return retrofit.create(MakeUpAPI::class.java)
  }
}

