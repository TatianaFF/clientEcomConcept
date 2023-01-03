package com.example.ecommerceconcept.fragments.detailPhone

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.ecommerceconcept.db.retroData.MainRemoteData
import com.example.ecommerceconcept.models.bestSellers.BestSellersResponseModel
import com.example.ecommerceconcept.models.cart.CartRequestModel
import com.example.ecommerceconcept.models.favorites.FavoriteRequestModel
import com.example.ecommerceconcept.models.phones.PhoneResponseModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val mainRemoteData: MainRemoteData
): ViewModel() {

    fun getPhoneById(id: String): LiveData<PhoneResponseModel> {
        return liveData {
            val data = mainRemoteData.getPhoneById(id)
            data.body()?.let { emit(it) }
        }
    }

    fun getBestSellerById(id: String): LiveData<BestSellersResponseModel> {
        return liveData {
            val data = mainRemoteData.getBestSellerById(id)
            data.body()?.let { emit(it) }
        }
    }

    fun insertCart(cart: CartRequestModel) {
        viewModelScope.launch {
            mainRemoteData.postCart(cart)
        }
    }

    fun deleteCart(id: String) {
        viewModelScope.launch {
            mainRemoteData.deleteCart(id)
        }
    }

    fun insertFavorite(favorite: FavoriteRequestModel) {
        viewModelScope.launch {
            mainRemoteData.postFavorite(favorite)
        }
    }

    fun deleteFavorite(id: String) {
        viewModelScope.launch {
            mainRemoteData.deleteFavorites(id)
        }
    }

}