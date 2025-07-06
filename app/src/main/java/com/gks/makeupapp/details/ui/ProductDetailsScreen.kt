package com.gks.makeupapp.details.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.gks.makeupapp.R
import com.gks.makeupapp.components.TopBar
import com.gks.makeupapp.details.domain.entity.DetailsContentLoadState

@Composable
fun ProductDetailsScreen(
  viewModel: ProductDetailsViewModel,
  id: Int,
  onBackClick: () -> Unit
) {
  LaunchedEffect(id) {
    viewModel.fetchProductDetails(id)
  }
  val productDetails by viewModel.productDetails.collectAsState(null)
  val contentLoadState by viewModel.contentLoadState.collectAsState(DetailsContentLoadState.NotStarted)

  when (contentLoadState) {
    is DetailsContentLoadState.Error -> Text(
      text = stringResource(R.string.error),
      fontSize = 32.sp,
    )
    DetailsContentLoadState.NotStarted, DetailsContentLoadState.Loading ->
        Column(
          modifier = Modifier
            .navigationBarsPadding()
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
        ) {
          Spacer(modifier = Modifier.height(80.dp))
          Box(
            modifier = Modifier
              .background(color = Color.Gray)
              .width(200.dp)
              .height(300.dp)
              .padding(bottom = 30.dp)
              .align(Alignment.CenterHorizontally),

          )
        }

    DetailsContentLoadState.Ready -> {
      Column() {
        TopBar(
          onClick = onBackClick,
          text = ""
        )
        Column(
          modifier = Modifier
            .navigationBarsPadding()
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
        ) {
          Spacer(modifier = Modifier.height(20.dp))
          AsyncImage(
            modifier = Modifier
              .width(200.dp)
              .height(300.dp)
              .padding(bottom = 30.dp)
              .align(Alignment.CenterHorizontally),
            model = productDetails?.imageLink,
            contentDescription = null,
            contentScale = ContentScale.FillHeight
          )
          if (productDetails?.name != null) {
            Text(
              modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, bottom = 10.dp)
                .align(Alignment.CenterHorizontally),
              text = productDetails!!.name,
              fontSize = 20.sp,
              fontWeight = FontWeight(600)
            )
          }
          if (productDetails?.description != null) {
            Text(
              modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, bottom = 10.dp),
              text = productDetails!!.description
            )
          }
        }
      }
    }
  }

}
