package com.gks.makeupapp.feature.catalog.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.max

@Composable
fun CategoryItem(
  @DrawableRes iconRes: Int,
  @StringRes nameRes: Int
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
      ),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {

    Icon(
      modifier = Modifier.size(60.dp),
      painter = painterResource(iconRes),
      tint = Color.Black,
      contentDescription = null
    )
    Spacer(modifier = Modifier.height(8.dp))
    Text(
      text = stringResource(nameRes)
    )
  }
}