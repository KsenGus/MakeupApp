package com.gks.makeupapp.details.data.di

import com.gks.makeupapp.details.data.ProductDetailsDataRepository
import com.gks.makeupapp.details.domain.ProductDetailsRepository
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

