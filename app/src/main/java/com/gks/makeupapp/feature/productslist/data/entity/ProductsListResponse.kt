package com.gks.makeupapp.feature.productslist.data.entity

import kotlinx.serialization.Serializable

@Serializable
data class DataProduct (
  val id: Int,
  val name: String,
  val brand: String?,
  val image_link: String?,
  val product_type: String,
  val rating: Double?
)