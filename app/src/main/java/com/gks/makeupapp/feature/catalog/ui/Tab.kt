package com.gks.makeupapp.feature.catalog.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun Tab(
  text: String,
  isActive: Boolean,
  onClick: () -> Unit,
  modifier: Modifier = Modifier
) {
  Column(
    modifier = modifier
      .clickable(onClick = onClick)
      .padding(top = 16.dp)
  ) {
    Text(
      modifier = Modifier.fillMaxWidth(),
      text = text,
      textAlign = TextAlign.Center
    )
    Spacer(
      modifier = Modifier
        .fillMaxWidth()
        .height(2.dp)
        .background(
          color = if (isActive) Color.Black else Color.Transparent
        )
    )
  }
}