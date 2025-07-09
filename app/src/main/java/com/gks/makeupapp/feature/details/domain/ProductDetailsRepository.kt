package com.gks.makeupapp.feature.details.domain

import com.gks.makeupapp.feature.details.domain.entity.ProductDetails
import com.gks.makeupapp.feature.productslist.domain.entity.Product
import kotlinx.coroutines.flow.Flow

interface ProductDetailsRepository {
  suspend fun fetchProductDetails(id: String)
  val productDetails: Flow<ProductDetails?>

  fun toggleLike(product: ProductDetails)
  val likedProducts: Flow<List<ProductDetails>>
}