package com.gks.makeupapp.feature.productslist.ui

import androidx.lifecycle.ViewModel
import com.gks.makeupapp.feature.productslist.domain.ProductsListUseCase
import com.gks.makeupapp.feature.productslist.domain.entity.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import java.math.BigDecimal
import java.math.BigInteger
import javax.inject.Inject

@HiltViewModel
class ProductsListViewModel @Inject constructor (
  private val useCase: ProductsListUseCase
) : ViewModel() {

  val products = useCase.products

  val contentLoadState = useCase.contentLoadState

  suspend fun fetchProductsByCategory(id: String) {
    useCase.fetchProductsByCategory(id)
  }

  suspend fun fetchProductsByBrand(id: String) {
    useCase.fetchProductsByBrand(id)
  }
  /*val productsList: List<Product> = listOf(
    Product(
"495",
      "Maybelline Face Studio Master Hi-Light Light Booster Bronzer",
      "https://d3t32hsnjxo7q6.cloudfront.net/i/991799d3e70b8856686979f8ff6dcfe0_ra,w158,h184_pa,w158,h184.png",
      "maybelline",
      "bronzer",
      5.0
    ),
    Product(
      "468",
      "Maybelline Face Studio Master Hi-Light Light Booster Blush",
      "https://d3t32hsnjxo7q6.cloudfront.net/i/4621032a92cb428ad640c105b944b39c_ra,w158,h184_pa,w158,h184.png",
      "maybelline",
      "blush",
      null
    ),
    Product(
      "398",
      "Maybelline Color Sensational Lipliner",
      "https://d3t32hsnjxo7q6.cloudfront.net/i/6607c1b7eb717dfbd3c228b61e4c5148_ra,w158,h184_pa,w158,h184.png",
      "maybelline",
      "lip_liner",
      4.8
    ),
    Product(
      "382",
      "Maybelline Dream Smooth Mousse Foundation",
      "https://d3t32hsnjxo7q6.cloudfront.net/i/fb79e7facf701176d4113527c284613f_ra,w158,h184_pa,w158,h184.png",
      "maybelline",
      "bronzer",
      5.0
    ),
    Product(
      "309",
      "Maybelline Expert Wear Eye Shadow Quad",
      "https://d3t32hsnjxo7q6.cloudfront.net/i/991799d3e70b8856686979f8ff6dcfe0_ra,w158,h184_pa,w158,h184.png",
      "maybelline",
      "eyeshadow",
      4.0
    )
  )*/
}


val i = BigDecimal.valueOf(4.5).stripTrailingZeros().toPlainString()