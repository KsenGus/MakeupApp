package com.gks.makeupapp.feature.productslist.domain.entity

data class Product(
  val id: Int,
  val name: String,
  val imageLink: String?,
  val brand: String?,
  val productType: String,
  val rating: Double?,
)