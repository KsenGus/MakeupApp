package com.gks.makeupapp.feature.catalog.data.di

import com.gks.makeupapp.feature.catalog.data.CategoryDataRepository
import com.gks.makeupapp.feature.catalog.domain.CategoryRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class CategoryDataModule {
  @Binds
  abstract fun bindCategoriesRepository(dataRepository: CategoryDataRepository): CategoryRepository
}