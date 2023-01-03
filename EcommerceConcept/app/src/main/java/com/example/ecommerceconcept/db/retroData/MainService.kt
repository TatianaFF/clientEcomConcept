package com.example.ecommerceconcept.db.retroData

import com.example.ecommerceconcept.models.bestSellers.BestSellersRequestModel
import com.example.ecommerceconcept.models.bestSellers.BestSellersResponseModel
import com.example.ecommerceconcept.models.cart.CartRequestModel
import com.example.ecommerceconcept.models.cart.CartResponseModel
import com.example.ecommerceconcept.models.favorites.FavoriteRequestModel
import com.example.ecommerceconcept.models.favorites.FavoriteResponseModel
import com.example.ecommerceconcept.models.hotSales.HotSalesRequestModel
import com.example.ecommerceconcept.models.hotSales.HotSalesResponseModel
import com.example.ecommerceconcept.models.phones.PhoneRequestModel
import com.example.ecommerceconcept.models.phones.PhoneResponseModel
import retrofit2.Response
import retrofit2.http.*

interface MainService {

    @GET("phones/get")
    suspend fun getPhones(): Response<List<PhoneResponseModel>>

    @POST("phones/create")
    suspend fun postPhones(@Body phone: PhoneRequestModel)

    @HTTP(method = "DELETE", path = "phones/{id}", hasBody = true)
    suspend fun deletePhones(@Path("id") id: String)

    @GET("phones/{id}")
    suspend fun getPhoneById(@Path("id") id: String): Response<PhoneResponseModel>



    @GET("hotsales/get")
    suspend fun getHotsales(): Response<List<HotSalesResponseModel>>

    @POST("hotsales/create")
    suspend fun postHotSales(@Body hotsales: HotSalesRequestModel)

    @HTTP(method = "DELETE", path = "hotsales/{id}", hasBody = true)
    suspend fun deleteHotSales(@Path("id") id: String)



    @GET("bestsellers/get")
    suspend fun getBestsellers(): Response<List<BestSellersResponseModel>>

    @POST("bestsellers/create")
    suspend fun postBestSeller(@Body bestseller: BestSellersRequestModel)

    @HTTP(method = "DELETE", path = "bestsellers/{id}", hasBody = true)
    suspend fun deleteBestSellers(@Path("id") id: String)

    @GET("bestsellers/{id}")
    suspend fun getBestSellerById(@Path("id") id: String): Response<BestSellersResponseModel>


    @GET("cart/get")
    suspend fun getCart(): Response<List<CartResponseModel>>

    @POST("cart/create")
    suspend fun postCart(@Body cart: CartRequestModel)

    @HTTP(method = "DELETE", path = "cart/{id}", hasBody = true)
    suspend fun deleteCart(@Path("id") id: String)

    @GET("cart/{id}")
    suspend fun getCartsByIdUser(@Path("id") id: String): Response<List<CartResponseModel>>



    @GET("favorites/get")
    suspend fun getFavorites(): Response<List<FavoriteResponseModel>>

    @POST("favorites/create")
    suspend fun postFavorite(@Body favorite: FavoriteRequestModel)

    @HTTP(method = "DELETE", path = "favorites/{id}", hasBody = true)
    suspend fun deleteFavorites(@Path("id") id: String)

    @GET("favorites/{id}")
    suspend fun getFavoritesByIdUser(@Path("id") id: String): Response<List<FavoriteResponseModel>>
}