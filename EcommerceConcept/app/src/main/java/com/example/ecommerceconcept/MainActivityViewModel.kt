package com.example.ecommerceconcept

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.ecommerceconcept.db.retroData.MainRemoteData
import com.example.ecommerceconcept.models.bestSellers.BestSellersRequestModel
import com.example.ecommerceconcept.models.cart.CartRequestModel
import com.example.ecommerceconcept.models.cart.CartResponseModel
import com.example.ecommerceconcept.models.favorites.FavoriteRequestModel
import com.example.ecommerceconcept.models.hotSales.HotSalesRequestModel
import com.example.ecommerceconcept.models.phones.PhoneRequestModel
import com.example.ecommerceconcept.models.phones.PhoneResponseModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val mainRemoteData: MainRemoteData
): ViewModel() {

    fun getCartsByIdUser(id: String): LiveData<List<CartResponseModel>> {
        return liveData {
            val data = mainRemoteData.getCartsByIdUser(id)
            data.body()?.let { emit(it) }
        }
    }

    fun getCart(): LiveData<List<CartResponseModel>> {
        return liveData {
            val data = mainRemoteData.getCart()
            data.body()?.let { emit(it) }
        }
    }

}