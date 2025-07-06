package com.gks.makeupapp.feature.catalog.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun BrandsLayout(
  viewModel: CategoryViewModel,
  onClick: (id: String, nameRes: Int) -> Unit,
) {

  LazyVerticalGrid(
    modifier = Modifier.padding(16.dp),
    columns = GridCells.Fixed(2),
    verticalArrangement = Arrangement.spacedBy(16.dp),
    horizontalArrangement = Arrangement.spacedBy(16.dp)
  ) {
    items(viewModel.brands) {
        brands -> BrandItem(brands.nameRes, onClick = { onClick(brands.id, brands.nameRes) })
    }
  }
}