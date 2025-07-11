package com.gks.makeupapp.feature.catalog.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun BrandItem(
  @StringRes nameRes: Int,
  onClick: () -> Unit,
) {
  Column(
    modifier = Modifier
      .clip(shape = RoundedCornerShape(12.dp))
      .width(150.dp)
      .height(150.dp)
      .border(
        width = 0.5.dp,
        color = Color.Black,
        shape = RoundedCornerShape(12.dp)
      )
      .clickable(onClick = onClick),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Text(
      text = stringResource(nameRes)
    )
  }
}