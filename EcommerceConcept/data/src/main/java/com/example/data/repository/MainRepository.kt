package com.example.data.repository


import androidx.room.Update
import com.example.data.models.bestSellers.BestSellersRequestModel
import com.example.data.models.bestSellers.BestSellersResponseModel
import com.example.data.models.cart.CartRequestModel
import com.example.data.models.cart.CartResponseModel
import com.example.data.models.favorites.FavoriteRequestModel
import com.example.data.models.favorites.FavoriteResponseModel
import com.example.models.hotSales.HotSalesRequestModel
import com.example.models.hotSales.HotSalesResponseModel
import com.example.data.models.phones.PhoneRequestModel
import com.example.data.models.phones.PhoneResponseModel
import com.example.models.cart.CartRequestUpdateModel
import retrofit2.Response
import retrofit2.http.*

interface MainRepository {

    @GET("phones/get")
    suspend fun getPhones(): Response<List<PhoneResponseModel>>

    @POST("phones/create")
    suspend fun postPhone(@Body phone: PhoneRequestModel)

    @HTTP(method = "DELETE", path = "phones/{id}", hasBody = true)
    suspend fun deletePhone(@Path("id") id: String)

    @GET("phones/{id}")
    suspend fun getPhoneById(@Path("id") id: String): Response<PhoneResponseModel>



    @GET("hotsales/get")
    suspend fun getHotsales(): Response<List<HotSalesResponseModel>>

    @POST("hotsales/create")
    suspend fun postHotSale(@Body hotsale: HotSalesRequestModel)

    @HTTP(method = "DELETE", path = "hotsales/{id}", hasBody = true)
    suspend fun deleteHotSale(@Path("id") id: String)



    @GET("bestsellers/get")
    suspend fun getBestSellers(): Response<List<BestSellersResponseModel>>

    @POST("bestsellers/create")
    suspend fun postBestSeller(@Body bestseller: BestSellersRequestModel)

    @HTTP(method = "DELETE", path = "bestsellers/{id}", hasBody = true)
    suspend fun deleteBestSeller(@Path("id") id: String)

    @GET("bestsellers/{id}")
    suspend fun getBestSellerById(@Path("id") id: String): Response<BestSellersResponseModel>


    @GET("cart/get")
    suspend fun getCarts(): Response<List<CartResponseModel>>

    @POST("cart/create")
    suspend fun postCart(@Body cart: CartRequestModel)

    @HTTP(method = "DELETE", path = "cart/{id}", hasBody = true)
    suspend fun deleteCart(@Path("id") id: String)

    @GET("cart/{id}")
    suspend fun getCartsByIdUser(@Path("id") id: String): Response<List<CartResponseModel>>

    @PATCH("cart/update")
    suspend fun updateCart(@Body cart: CartRequestUpdateModel)



    @GET("favorites/get")
    suspend fun getFavorites(): Response<List<FavoriteResponseModel>>

    @POST("favorites/create")
    suspend fun postFavorite(@Body favorite: FavoriteRequestModel)

    @HTTP(method = "DELETE", path = "favorites/{id}", hasBody = true)
    suspend fun deleteFavorite(@Path("id") id: String)

    @GET("favorites/{id}")
    suspend fun getFavoritesByIdUser(@Path("id") id: String): Response<List<FavoriteResponseModel>>
}