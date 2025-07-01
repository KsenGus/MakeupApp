package com.gks.makeupapp.feature.catalog.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun CatalogScreen(
  modifier: Modifier,
  viewModel: CategoryViewModel
) {
  var activeTab by remember { mutableStateOf(CatalogTab.CATEGORY) }

  Column(
    modifier = Modifier.systemBarsPadding()
  ) {
    Tabs(
      activeTab = activeTab,
      tabs = CatalogTab.entries,
      onClick = { tab -> activeTab = tab }
    )
    when (activeTab) {
      CatalogTab.CATEGORY -> CategoriesScreen(viewModel = viewModel)
      CatalogTab.BRAND -> BrandsLayout(viewModel = viewModel)
    }
  }
}


@Composable
fun Tabs(
  activeTab: CatalogTab,
  tabs: List<CatalogTab>,
  onClick: (CatalogTab) -> Unit,
  modifier: Modifier = Modifier
) {
  Row(
    modifier = modifier
      .fillMaxWidth()
  ) {
    tabs.forEach { tab ->
      Tab(
        modifier = Modifier.weight(1f),
        text = tab.name,
        isActive = activeTab == tab,
        onClick = { onClick(tab) }
      )
    }
  }
}

enum class CatalogTab {
  CATEGORY, BRAND
}