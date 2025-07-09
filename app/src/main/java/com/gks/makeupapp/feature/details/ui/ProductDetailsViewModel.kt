package com.gks.makeupapp.feature.details.ui

import androidx.lifecycle.ViewModel
import com.gks.makeupapp.feature.details.domain.ProductDetailsUseCase
import com.gks.makeupapp.feature.details.domain.entity.ProductDetails
import com.gks.makeupapp.feature.productslist.domain.entity.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductDetailsViewModel @Inject constructor(
  private val useCase: ProductDetailsUseCase
): ViewModel() {
  val contentLoadState = useCase.detailsContentLoadState

  suspend fun fetchProductDetails(id: Int) {
    useCase.fetchProductDetails(id)
  }

  fun toggleLike(product: ProductDetails) {
    useCase.toggleLike(product)
  }

  val productDetails = useCase.productDetails
  val likedProducts = useCase.likedProducts
}