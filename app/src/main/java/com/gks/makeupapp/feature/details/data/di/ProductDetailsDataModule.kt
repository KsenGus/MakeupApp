package com.gks.makeupapp.feature.details.data.di

import com.gks.makeupapp.feature.details.data.ProductDetailsDataRepository
import com.gks.makeupapp.feature.details.domain.ProductDetailsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ProductDetailsDataModule {
  @Binds
  abstract fun bindCategoriesRepository(dataRepository: ProductDetailsDataRepository): ProductDetailsRepository
}

