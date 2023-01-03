package com.example.ecommerceconcept.db.retroData

import com.example.ecommerceconcept.models.bestSellers.BestSellersRequestModel
import com.example.ecommerceconcept.models.cart.CartRequestModel
import com.example.ecommerceconcept.models.favorites.FavoriteRequestModel
import com.example.ecommerceconcept.models.favorites.FavoriteResponseModel
import com.example.ecommerceconcept.models.hotSales.HotSalesRequestModel
import com.example.ecommerceconcept.models.hotSales.HotSalesResponseModel
import com.example.ecommerceconcept.models.phones.PhoneRequestModel
import javax.inject.Inject

class MainRemoteData @Inject constructor(private val mainService : MainService) {

    suspend fun getPhones() = mainService.getPhones()
    suspend fun postPhones(phone: PhoneRequestModel) = mainService.postPhones(phone)
    suspend fun deletePhones(id: String) = mainService.deletePhones(id)
    suspend fun getPhoneById(id: String) = mainService.getPhoneById(id)

    suspend fun getHotsales() = mainService.getHotsales()
    suspend fun postHotSales(hotsales: HotSalesRequestModel) = mainService.postHotSales(hotsales)
    suspend fun deleteHotSales(id: String) = mainService.deleteHotSales(id)

    suspend fun getBestsellers() = mainService.getBestsellers()
    suspend fun postBestSeller(bestseller: BestSellersRequestModel) = mainService.postBestSeller(bestseller)
    suspend fun deleteBestSellers(id: String) = mainService.deleteBestSellers(id)
    suspend fun getBestSellerById(id: String) = mainService.getBestSellerById(id)

    suspend fun getCart() = mainService.getCart()
    suspend fun postCart(cart: CartRequestModel) = mainService.postCart(cart)
    suspend fun deleteCart(id: String) = mainService.deleteCart(id)
    suspend fun getCartsByIdUser(id: String) = mainService.getCartsByIdUser(id)

    suspend fun getFavorites() = mainService.getFavorites()
    suspend fun postFavorite(favorite: FavoriteRequestModel) = mainService.postFavorite(favorite)
    suspend fun deleteFavorites(id: String) = mainService.deleteFavorites(id)
    suspend fun getFavoritesByIdUser(id: String) = mainService.getFavoritesByIdUser(id)

}