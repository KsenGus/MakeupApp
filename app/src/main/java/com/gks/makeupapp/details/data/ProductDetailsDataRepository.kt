package com.gks.makeupapp.details.data

import api.MakeUpAPI
import com.gks.makeupapp.details.data.mappers.toDomainModel
import com.gks.makeupapp.details.domain.ProductDetailsRepository
import com.gks.makeupapp.details.domain.entity.ProductDetails
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class ProductDetailsDataRepository @Inject constructor(
  private val api: MakeUpAPI
) : ProductDetailsRepository {
  private val cache = MutableStateFlow<ProductDetails?>(null)

  override suspend fun fetchProductDetails(id: String) {
    val response = api.fetchProductDetails(id)
    cache.value = response.toDomainModel()
  }

  override val productDetails: Flow<ProductDetails?> = cache
}