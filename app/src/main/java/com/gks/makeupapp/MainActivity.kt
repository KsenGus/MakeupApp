package com.gks.makeupapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.gks.makeupapp.feature.catalog.domain.entity.Brand
import com.gks.makeupapp.feature.catalog.ui.BrandsLayout
import com.gks.makeupapp.feature.catalog.ui.CatalogScreen
import com.gks.makeupapp.feature.catalog.ui.CategoryViewModel
import com.gks.makeupapp.ui.theme.MakeupAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      MakeupAppTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          CatalogScreen(
            viewModel = hiltViewModel<CategoryViewModel>(),
            modifier = Modifier.padding(innerPadding)
          )
        }
      }
    }
  }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
  Text(
    text = "Hello $name!",
    modifier = modifier
  )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  MakeupAppTheme {
    Greeting("Android")
  }
}