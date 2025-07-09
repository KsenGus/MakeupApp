package com.gks.makeupapp.feature.productslist.data

import api.MakeUpAPI
import com.gks.makeupapp.feature.catalog.domain.entity.Brand
import com.gks.makeupapp.feature.productslist.data.mapper.toDomainModel
import com.gks.makeupapp.feature.productslist.domain.ProductsListRepository
import com.gks.makeupapp.feature.productslist.domain.entity.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.any
import kotlinx.coroutines.flow.emptyFlow
import javax.inject.Inject

class ProductsListDataRepository @Inject constructor(
  val api: MakeUpAPI
) : ProductsListRepository {
  private val cache = MutableStateFlow<List<Product?>>(emptyList())
  private val likedCache = MutableStateFlow<List<Product>>(emptyList())

  override suspend fun fetchProductsByCategory(id: String) {
    val response = api.fetchProductsByProductType(id)
    val products = response.map { it.toDomainModel() }
    cache.value = products
  }

  override suspend fun fetchProductsByBrand(id: String) {
    val response = api.fetchProductsByBrand(id)
    val brands = response.map { it.toDomainModel() }
    cache.value = brands
  }

  override fun toggleLike(product: Product) {
    if (likedCache.value.any { likedProduct -> likedProduct.id == product.id }) {
      likedCache.value = likedCache.value.minus(product)
    } else {
      likedCache.value = likedCache.value.plus(product)
    }
  }

  override val products: Flow<List<Product?>> = cache// todo @gks
  override val likedProducts: Flow<List<Product>> = likedCache
}