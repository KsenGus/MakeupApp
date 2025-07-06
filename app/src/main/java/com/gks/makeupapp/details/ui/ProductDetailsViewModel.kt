package com.gks.makeupapp.details.ui

import androidx.lifecycle.ViewModel
import com.gks.makeupapp.details.domain.ProductDetailsUseCase
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
  val productDetails = useCase.productDetails
}