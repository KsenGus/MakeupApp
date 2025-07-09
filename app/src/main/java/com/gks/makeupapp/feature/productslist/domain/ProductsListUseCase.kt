package com.gks.makeupapp.feature.productslist.domain

import com.gks.makeupapp.feature.productslist.domain.entity.ContentLoadState
import com.gks.makeupapp.feature.productslist.domain.entity.Product
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class ProductsListUseCase @Inject constructor(
  private val repository: ProductsListRepository
) {
  val contentLoadState = MutableStateFlow<ContentLoadState>(ContentLoadState.NotStarted)

  suspend fun fetchProductsByCategory(id: String) {
    try {
      contentLoadState.value = ContentLoadState.Loading
      repository.fetchProductsByCategory(id)
      contentLoadState.value = ContentLoadState.Ready
    } catch (e: Throwable) {
      e.printStackTrace()
      contentLoadState.value = ContentLoadState.Error(e)
    }
  }

  val products = repository.products
  val likedProducts = repository.likedProducts

  fun toggleLike(product: Product) {
    repository.toggleLike(product)
  }

  suspend fun fetchProductsByBrand(id: String) {
    try {
      contentLoadState.value = ContentLoadState.Loading
      repository.fetchProductsByBrand(id)
      contentLoadState.value = ContentLoadState.Ready
    } catch (e: Throwable) {
      e.printStackTrace()
      contentLoadState.value = ContentLoadState.Error(e)
    }
  }
}
