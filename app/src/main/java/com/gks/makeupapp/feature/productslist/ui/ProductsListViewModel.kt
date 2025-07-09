package com.gks.makeupapp.feature.productslist.ui

import androidx.lifecycle.ViewModel
import com.gks.makeupapp.feature.productslist.domain.ProductsListUseCase
import com.gks.makeupapp.feature.productslist.domain.entity.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import java.math.BigDecimal
import java.math.BigInteger
import javax.inject.Inject

@HiltViewModel
class ProductsListViewModel @Inject constructor (
  private val useCase: ProductsListUseCase
) : ViewModel() {

  val products = useCase.products

  val contentLoadState = useCase.contentLoadState

  suspend fun fetchProductsByCategory(id: String) {
    useCase.fetchProductsByCategory(id)
  }

  suspend fun fetchProductsByBrand(id: String) {
    useCase.fetchProductsByBrand(id)
  }

  fun toggleLike(product: Product) {
    useCase.toggleLike(product)
  }

  val likedProducts = useCase.likedProducts
}


val i = BigDecimal.valueOf(4.5).stripTrailingZeros().toPlainString()