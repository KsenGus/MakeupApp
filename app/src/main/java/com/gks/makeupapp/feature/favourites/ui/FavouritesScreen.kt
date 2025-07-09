package com.gks.makeupapp.feature.favourites.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gks.makeupapp.R
import com.gks.makeupapp.components.TopBar
import com.gks.makeupapp.feature.productslist.domain.entity.Product
import com.gks.makeupapp.feature.productslist.ui.ProductItem

@Composable
fun FavouritesScreen(
  onProductClick: (productId: Int) -> Unit
) {
  val products: List<Product> = listOf(
    Product(
      id = 1047,
      name = "Blotted Lip",
      imageLink = "https://cdn.shopify.com/s/files/1/1338/0845/products/brain-freeze_a_800x1200.jpg?v=1502255076",
      brand = "colourpop",
      productType = "lipstick",
      rating = 4.5
    ),
    Product(
      id = 1044,
      name = "Lip",
      imageLink = "https://cdn.shopify.com/s/files/1/1016/3243/products/LIPBALM_LID_grande.jpg?v=1496848378",
      brand = "boosh",
      productType = "lipstick",
      rating = 4.8
    ),
    Product(
      id = 113,
      name = "CoverGirl Outlast Lipcolor Moisturizing Clear Topcoat (500)",
      imageLink = "https://d3t32hsnjxo7q6.cloudfront.net/i/00bee78599bf386be435237a1515fdb7_ra,w158,h184_pa,w158,h184.jpg",
      brand = "covergirl",
      productType = "lipstick",
      rating = 5.0
    )
  )

  Column {
    Box (
      modifier = Modifier
        .background(color = Color.Magenta)
        .statusBarsPadding()
        .height(70.dp)
        .fillMaxWidth()
        .padding(12.dp, 16.dp),
      contentAlignment = Alignment.Center
    ) {
      Text(
        text = stringResource(R.string.favourites),
        fontSize = 32.sp
      )
    }
    LazyVerticalGrid(
      modifier = Modifier
        .padding(16.dp),
      columns = GridCells.Fixed(2),
      verticalArrangement = Arrangement.spacedBy(16.dp),
      horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
      items(products) { product ->
        ProductItem(
          product.name,
          product.imageLink,
          product.brand,
          product.productType,
          product.rating,
          onClick = { onProductClick(product.id) },
          onLikeClick = { onProductClick(product.id) },
          isLiked = true
        )
      }
    }
  }
}


