package com.gks.makeupapp.feature.catalog.domain.entity

import androidx.annotation.StringRes

data class Brand (
  val id: String,
  @StringRes val nameRes: Int
)