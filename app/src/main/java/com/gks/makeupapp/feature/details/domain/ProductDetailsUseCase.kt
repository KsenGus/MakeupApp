package com.gks.makeupapp.feature.details.domain

import com.gks.makeupapp.feature.details.domain.entity.DetailsContentLoadState
import com.gks.makeupapp.feature.details.domain.entity.ProductDetails
import com.gks.makeupapp.feature.productslist.domain.entity.ContentLoadState
import com.gks.makeupapp.feature.productslist.domain.entity.Product
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class ProductDetailsUseCase @Inject constructor(
  private val repository: ProductDetailsRepository
) {

  val detailsContentLoadState = MutableStateFlow<DetailsContentLoadState>(DetailsContentLoadState.NotStarted)

  suspend fun fetchProductDetails(id: Int) {
    try {
      detailsContentLoadState.value = DetailsContentLoadState.Loading
      repository.fetchProductDetails(id.toString())
      detailsContentLoadState.value = DetailsContentLoadState.Ready
    } catch (error: Throwable) {
      error.printStackTrace()
      detailsContentLoadState.value = DetailsContentLoadState.Error(error)
    }
  }

  fun toggleLike(product: ProductDetails) {
    repository.toggleLike(product)
  }

  val productDetails = repository.productDetails
  val likedProducts = repository.likedProducts
}