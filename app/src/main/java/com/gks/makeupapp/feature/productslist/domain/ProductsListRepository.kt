package com.gks.makeupapp.feature.productslist.domain

import com.gks.makeupapp.feature.catalog.domain.entity.Brand
import com.gks.makeupapp.feature.productslist.domain.entity.Product
import kotlinx.coroutines.flow.Flow

interface ProductsListRepository {
  suspend fun fetchProductsByCategory(id: String)
  val products: Flow<List<Product?>>
  suspend fun fetchProductsByBrand(id: String)

  fun toggleLike(product: Product)
  val likedProducts: Flow<List<Product>>
}