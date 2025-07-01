package com.gks.makeupapp.feature.catalog.ui

import androidx.lifecycle.ViewModel
import com.gks.makeupapp.R
import com.gks.makeupapp.feature.catalog.domain.CategoryUseCase
import com.gks.makeupapp.feature.catalog.domain.entity.Brand
import com.gks.makeupapp.feature.catalog.domain.entity.Category
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
  useCase: CategoryUseCase): ViewModel() {
  val categories: List<Category> = listOf(
  Category(
  id = "blush",
  iconRes = R.drawable.ic_blush_91_113,
  nameRes = R.string.blush),
  Category(
  id = "bronzer",
  iconRes = R.drawable.ic_bronzer_91_113,
  nameRes = R.string.bronzer),
  Category(
  id = "eyeliner",
  iconRes = R.drawable.ic_eyeliner_91_113,
  nameRes = R.string.eyeliner),
  Category(
  id = "eyebrow",
  iconRes = R.drawable.ic_eyebrow_100_125,
  nameRes = R.string.eyebrow),
  Category(
  id = "eyeshadow",
  iconRes = R.drawable.ic_eyeshadow_60_58,
  nameRes = R.string.eyeshadow
  ),
  Category(
  id = "foundation",
  iconRes = R.drawable.ic_foundation_100_125,
  nameRes = R.string.foundation),
  Category(
  id = "lipliner",
  iconRes = R.drawable.ic_lip_liner_512_640,
  nameRes = R.string.lipliner),
  Category(
  id = "lipstick",
  iconRes = R.drawable.ic_lipstick_100_125,
  nameRes = R.string.lipstick),
  Category(
  id = "mascara",
  iconRes = R.drawable.ic_mascara_32_86,
  nameRes = R.string.mascara
  ),
  Category(
  id = "nailpolish",
  iconRes = R.drawable.ic_nail_polish_100_125,
  nameRes = R.string.nail_polish
  ),
  )

  val brands: List<Brand> = listOf(
    Brand("almay", R.string.almay),
    Brand("dior", R.string.dior),
    Brand("loreal", R.string.loreal),
    Brand("maybelline", R.string.maybelline),
    Brand("nyx", R.string.nyx),
  )
}