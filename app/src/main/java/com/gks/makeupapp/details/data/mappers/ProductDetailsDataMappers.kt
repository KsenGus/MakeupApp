package com.gks.makeupapp.details.data.mappers

import com.gks.makeupapp.details.data.entity.ProductDetailsResponse
import com.gks.makeupapp.details.domain.entity.ProductDetails

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