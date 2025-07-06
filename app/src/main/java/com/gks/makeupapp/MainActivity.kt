package com.gks.makeupapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.gks.makeupapp.details.ui.ProductDetailsScreen
import com.gks.makeupapp.details.ui.ProductDetailsViewModel
import com.gks.makeupapp.feature.catalog.ui.Catalog
import com.gks.makeupapp.feature.catalog.ui.CatalogScreen
import com.gks.makeupapp.feature.catalog.ui.CategoryViewModel
import com.gks.makeupapp.feature.productslist.ui.ProductsListScreen
import com.gks.makeupapp.feature.productslist.ui.ProductsListViewModel
import com.gks.makeupapp.ui.theme.MakeupAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.serialization.Serializable

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      val navController = rememberNavController()

      MakeupAppTheme {
        Scaffold(modifier = Modifier.fillMaxSize())
        { _ ->
          NavHost(navController = navController, startDestination = CATALOG_ROUTE) {
            composable(CATALOG_ROUTE) {
              val categoryViewModel = hiltViewModel<CategoryViewModel>()
              CatalogScreen(
                viewModel = categoryViewModel,
                onClick = { catalog -> navController.navigate(CatalogScreen(catalog.serialize())) }
              )
            }
            composable<CatalogScreen> {
              val catalogScreen = it.toRoute<CatalogScreen>()
              ProductsListScreen(
                viewModel = hiltViewModel<ProductsListViewModel>(),
                catalogSerialized = catalogScreen.catalog,
                onProductClick = { id -> navController.navigate(ProductId(id)) },
                onBackClick = { navController.popBackStack() }
              )
            }
            composable<ProductId> {
              val productId = it.toRoute<ProductId>()
              val productDetailsViewModel = hiltViewModel<ProductDetailsViewModel>()
              ProductDetailsScreen(
                viewModel = productDetailsViewModel,
                id = productId.value,
                onBackClick = { navController.popBackStack() }
              )
            }
          }
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

private const val CATALOG_ROUTE = "catalog"
private const val PRODUCT_ROUTE = "product"

@Serializable
data class CatalogScreen(val catalog: String)


@Serializable
data class ProductId (
  val value: Int
)

fun Catalog.serialize(): String {
  val catalogString =
    when(this) {
      is Catalog.Category -> "category"
      is Catalog.Brand -> "brand"
    }
  return catalogString + "::" + this.id + "::" + this.title.toString()
}

fun String.deserialize(): Catalog {
  var array = this.split("::")
  return when (array[0]) {
    "brand" -> Catalog.Brand(array[1], array[2].toInt())
    "category" -> Catalog.Category(array[1], array[2].toInt())
    else -> error("unknown catalog value")
  }
}