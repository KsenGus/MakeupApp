package com.gks.makeupapp.components

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ModalDrawer
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gks.makeupapp.R

@Composable
fun TopBar(
  onClick: ()->Unit,
  text: String
) {
  Row (
    modifier = Modifier
      .background(color = Color.Magenta)
      .statusBarsPadding()
      .height(70.dp)
      .fillMaxWidth()
      .padding(12.dp, 16.dp),
    verticalAlignment = Alignment.CenterVertically
  ) {
    IconButton(
      onClick = onClick
    ) {
      Icon(
        painter = painterResource(R.drawable.ic_chevron_large_24),
        tint = Color.Black,
        contentDescription = null
      )
    }
    Spacer(modifier = Modifier.weight(0.75f))
    Text(
      text = text,
      fontSize = 32.sp
    )
    Spacer(modifier = Modifier.weight(1f))
  }
}