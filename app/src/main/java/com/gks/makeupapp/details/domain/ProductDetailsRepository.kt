package com.gks.makeupapp.details.domain

import com.gks.makeupapp.details.domain.entity.ProductDetails
import kotlinx.coroutines.flow.Flow

interface ProductDetailsRepository {
  suspend fun fetchProductDetails(id: String)
  val productDetails: Flow<ProductDetails?>
}