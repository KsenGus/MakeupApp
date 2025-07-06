package com.gks.makeupapp.feature.productslist.domain.entity

sealed class ContentLoadState {
  data object NotStarted : ContentLoadState()
  data object Loading : ContentLoadState()
  data object Ready : ContentLoadState()
  data class Error(val error: Throwable) : ContentLoadState()
}