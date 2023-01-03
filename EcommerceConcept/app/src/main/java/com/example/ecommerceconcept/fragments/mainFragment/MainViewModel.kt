package com.example.ecommerceconcept.fragments.mainFragment

import androidx.lifecycle.*
import com.example.ecommerceconcept.db.retroData.MainRemoteData
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
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRemoteData: MainRemoteData
): ViewModel() {

    fun getPhones(): LiveData<List<PhoneResponseModel>> {
        return liveData {
            val data = mainRemoteData.getPhones()
            data.body()?.let { emit(it) }
        }
    }

    fun getPhoneById(id: String): LiveData<PhoneResponseModel> {
        return liveData {
            val data = mainRemoteData.getPhoneById(id)
            data.body()?.let { emit(it) }
        }
    }

    fun getHotsales(): LiveData<List<HotSalesResponseModel>> {
        return liveData {
            val data = mainRemoteData.getHotsales()
            data.body()?.let { emit(it) }
        }
    }

    fun getBestsellers(): LiveData<List<BestSellersResponseModel>> {
        return liveData {
            val data = mainRemoteData.getBestsellers()
            data.body()?.let { emit(it) }
        }
    }
}