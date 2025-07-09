package com.gks.makeupapp.feature.productslist.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gks.makeupapp.ProductId
import com.gks.makeupapp.R
import com.gks.makeupapp.components.TopBar
import com.gks.makeupapp.deserialize
import com.gks.makeupapp.feature.catalog.ui.Catalog
import com.gks.makeupapp.feature.productslist.domain.entity.ContentLoadState

@Composable
fun ProductsListScreen(
  modifier: Modifier = Modifier,
  viewModel: ProductsListViewModel,
  catalogSerialized: String,
  onProductClick: (productId: Int) -> Unit,
  onBackClick: ()->Unit
) {
  val products by viewModel.products.collectAsState(emptyList())
  val catalog = remember(catalogSerialized) { catalogSerialized.deserialize() }
  val contentLoadState by viewModel.contentLoadState.collectAsState(ContentLoadState.NotStarted)
  val likedProducts by viewModel.likedProducts.collectAsState(emptyList())

  LaunchedEffect(catalogSerialized) {
    when (catalog) {
      is Catalog.Brand -> viewModel.fetchProductsByBrand(catalog.id)
      is Catalog.Category -> viewModel.fetchProductsByCategory(catalog.id)
    }
  }

  Column(
    modifier = Modifier
      .navigationBarsPadding()
      .fillMaxWidth(),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    when (contentLoadState) {
      is ContentLoadState.Error -> Text(
        text = stringResource(R.string.error),
        fontSize = 32.sp,
      )
      ContentLoadState.NotStarted, ContentLoadState.Loading -> {
        LazyVerticalGrid(
          modifier = Modifier
            .statusBarsPadding()
            .padding(top = 80.dp, start = 16.dp, end = 16.dp),
          columns = GridCells.Fixed(2),
          verticalArrangement = Arrangement.spacedBy(16.dp),
          horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
          items(6) {
            Box(
              modifier = Modifier
                .background(color = Color.Gray, shape = RoundedCornerShape(12.dp))
                .width(150.dp)
                .height(300.dp)
                .border(
                  width = 0.5.dp,
                  color = Color.Black,
                  shape = RoundedCornerShape(12.dp)
                )
            )
          }
        }
      }
      ContentLoadState.Ready -> {
        TopBar(
          onClick = onBackClick,
          text = stringResource(catalog.title)
        )
        LazyVerticalGrid(
          modifier = Modifier
            .padding(16.dp),
          columns = GridCells.Fixed(2),
          verticalArrangement = Arrangement.spacedBy(16.dp),
          horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
          items(products) { product ->
            ProductItem(
              product!!.name,
              product.imageLink,
              product.brand,
              product.productType,
              product.rating,
              onClick = { onProductClick(product.id) },
              onLikeClick = { viewModel.toggleLike(product) },
              isLiked = likedProducts.any{ likedProduct -> likedProduct.id == product.id}
            )
          }
        }
      }
    }

  }
}