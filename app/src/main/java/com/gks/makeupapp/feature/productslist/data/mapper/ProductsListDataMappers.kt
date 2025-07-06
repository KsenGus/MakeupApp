package com.gks.makeupapp.feature.productslist.data.mapper

import com.gks.makeupapp.feature.productslist.data.entity.DataProduct
import com.gks.makeupapp.feature.productslist.domain.entity.Product

internal fun DataProduct.toDomainModel() : Product {
  return Product(
    id = id,
    name = name,
    brand = brand,
    imageLink = image_link,
    productType = product_type,
    rating = rating
  )
}