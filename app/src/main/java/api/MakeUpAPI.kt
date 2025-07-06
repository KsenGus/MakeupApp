package api

import com.gks.makeupapp.details.data.entity.ProductDetailsResponse
import com.gks.makeupapp.feature.productslist.data.entity.DataProduct

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MakeUpAPI {

  @GET("v1/products.json")
  suspend fun fetchProductsByProductType(
    @Query("product_type") productType: String
  ): List<DataProduct>

  @GET("v1/products.json")
  suspend fun fetchProductsByBrand(
    @Query("brand") brand: String
  ): List<DataProduct>

  @GET("v1/products/{id}.json")
  suspend fun fetchProductDetails(
  @Path("id") id: String) : ProductDetailsResponse
}