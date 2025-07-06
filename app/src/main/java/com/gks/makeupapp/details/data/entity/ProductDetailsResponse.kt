package com.gks.makeupapp.details.data.entity

import kotlinx.serialization.Serializable

@Serializable
data class ProductDetailsResponse(
  val id: Int,
  val brand: String,
  val name: String,
  val image_link: String?,
  val description: String,
  val product_link: String?
)