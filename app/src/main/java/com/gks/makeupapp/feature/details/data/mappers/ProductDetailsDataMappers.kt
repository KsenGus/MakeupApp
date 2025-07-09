package com.gks.makeupapp.feature.details.data.mappers

import com.gks.makeupapp.feature.details.data.entity.ProductDetailsResponse
import com.gks.makeupapp.feature.details.domain.entity.ProductDetails

internal fun ProductDetailsResponse.toDomainModel() : ProductDetails {
  return ProductDetails(
    brand = brand,
    name = name,
    imageLink = image_link,
    description = description,
    productLink = product_link,
    id = id
  )
}