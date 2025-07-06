package com.gks.makeupapp.details.domain.entity

sealed class DetailsContentLoadState {
  data object NotStarted : DetailsContentLoadState()
  data object Loading : DetailsContentLoadState()
  data object Ready : DetailsContentLoadState()
  data class Error(val error: Throwable) : DetailsContentLoadState()
}