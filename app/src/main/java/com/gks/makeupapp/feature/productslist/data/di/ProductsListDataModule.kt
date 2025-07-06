package com.gks.makeupapp.feature.productslist.data.di

import com.gks.makeupapp.feature.catalog.data.CategoryDataRepository
import com.gks.makeupapp.feature.catalog.domain.CategoryRepository
import com.gks.makeupapp.feature.productslist.data.ProductsListDataRepository
import com.gks.makeupapp.feature.productslist.domain.ProductsListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ProductsListDataModule {
  @Binds
  abstract fun bindCategoriesRepository(dataRepository: ProductsListDataRepository): ProductsListRepository
}