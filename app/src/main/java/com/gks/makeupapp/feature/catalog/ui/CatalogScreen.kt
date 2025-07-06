package com.gks.makeupapp.feature.catalog.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.gks.makeupapp.feature.catalog.domain.entity.Category
import kotlinx.serialization.Serializable

@Composable
fun CatalogScreen(
  viewModel: CategoryViewModel,
  onClick: (catalog: Catalog) -> Unit,
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
      CatalogTab.CATEGORY -> {
        CategoriesScreen(
          viewModel = viewModel,
          onClick = { id, nameRes -> onClick(Catalog.Category(id, nameRes)) }
        )
      }
      CatalogTab.BRAND -> BrandsLayout(viewModel = viewModel, onClick = { id, nameRes ->
        onClick(Catalog.Brand(id, nameRes))
      })
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

@Immutable
@Serializable
sealed class Catalog(
  @StringRes open val title: Int,
  open val id: String
) {
  @Immutable
  data class Category(
    override val id: String,
    @StringRes override val title: Int
  ): Catalog(title, id)

  @Immutable
  data class Brand(
    override val id: String,
    @StringRes override val title: Int
  ) : Catalog(title, id)
}
