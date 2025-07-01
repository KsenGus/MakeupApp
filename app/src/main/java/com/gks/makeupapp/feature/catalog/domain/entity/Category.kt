package com.gks.makeupapp.feature.catalog.domain.entity

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Category (
  val id: String,
  @DrawableRes val iconRes: Int,
  @StringRes val nameRes: Int
)