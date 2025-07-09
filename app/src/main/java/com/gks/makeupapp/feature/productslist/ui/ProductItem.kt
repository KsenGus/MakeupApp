package com.gks.makeupapp.feature.productslist.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.gks.makeupapp.R
import java.math.BigDecimal

@Composable
fun ProductItem(
  name: String,
  imageLink: String?,
  brand: String?,
  productType: String,
  rating: Double?,
  onClick: ()->Unit,
  isLiked: Boolean,
  onLikeClick: ()->Unit
) {
  Column(
    modifier = Modifier
      .clip(shape = RoundedCornerShape(12.dp))
      .width(150.dp)
      .height(300.dp)
      .border(
        width = 0.5.dp,
        color = Color.Black,
        shape = RoundedCornerShape(12.dp)
      )
      .padding(12.dp)
      .clickable(onClick = onClick),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Row(
      verticalAlignment = Alignment.CenterVertically
    ) {
      if (rating != null){
        Icon(
          painter = painterResource(R.drawable.ic_star_8),
          contentDescription = null,
          tint = Color.Yellow
        )
        Text(
          text = BigDecimal.valueOf(rating).stripTrailingZeros().toPlainString()
        )
      }
      Spacer(modifier = Modifier.weight(1f))
      IconButton(
        onClick = onLikeClick
      ) {
        Icon(
          painter = painterResource(R.drawable.ic_heart_24),
          contentDescription = null,
          tint = if(isLiked) Color.Red else Color.Black
        )
      }
    }
    Spacer(modifier = Modifier.weight(1f))
    AsyncImage(
      modifier = Modifier
        .width(100.dp)
        .height(120.dp),
      model = imageLink,
      contentDescription = null,
      contentScale = ContentScale.FillHeight
    )
    Spacer(modifier = Modifier.weight(1f))
    Text(
      modifier = Modifier
        .padding(bottom = 5.dp),
      text = name,
      fontSize = 14.sp,
      fontWeight = FontWeight(600),
      textAlign = TextAlign.Center
    )
    Text(
      modifier = Modifier.padding(bottom = 5.dp),
      text = brand.orEmpty(),
      fontSize = 12.sp,
      textAlign = TextAlign.Center
    )
  }
}