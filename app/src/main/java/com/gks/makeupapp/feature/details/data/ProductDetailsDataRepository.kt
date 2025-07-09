package com.gks.makeupapp.feature.details.data

import api.MakeUpAPI
import com.gks.makeupapp.feature.details.data.mappers.toDomainModel
import com.gks.makeupapp.feature.details.domain.ProductDetailsRepository
import com.gks.makeupapp.feature.details.domain.entity.ProductDetails
import com.gks.makeupapp.feature.productslist.domain.entity.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class ProductDetailsDataRepository @Inject constructor(
  private val api: MakeUpAPI
) : ProductDetailsRepository {
  private val cache = MutableStateFlow<ProductDetails?>(null)
  private val likedCache = MutableStateFlow<List<ProductDetails>>(emptyList())

  override suspend fun fetchProductDetails(id: String) {
    val response = api.fetchProductDetails(id)
    cache.value = response.toDomainModel()
  }

  override fun toggleLike(product: ProductDetails) {
    if(likedCache.value.any{ likedProduct -> likedProduct.id == product.id }) {
      likedCache.value = likedCache.value.minus(product)
    }
    else likedCache.value = likedCache.value.plus(product)
  }

  override val productDetails: Flow<ProductDetails?> = cache
  override val likedProducts: Flow<List<ProductDetails>> = likedCache
}