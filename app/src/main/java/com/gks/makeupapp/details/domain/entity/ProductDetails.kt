package com.gks.makeupapp.details.domain.entity

import androidx.compose.runtime.Immutable

@Immutable
data class ProductDetails(
  val id: Int,
  val brand: String,
  val name: String,
  val imageLink: String?,
  val description: String,
  val productLink: String?
)
