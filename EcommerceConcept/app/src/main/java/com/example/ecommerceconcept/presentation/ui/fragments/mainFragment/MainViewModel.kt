package com.example.ecommerceconcept.presentation.ui.fragments.mainFragment

import androidx.lifecycle.*
import com.example.data.models.bestSellers.BestSellersResponseModel
import com.example.data.models.phones.PhoneResponseModel
import com.example.domain.usecase.bestSellers.GetBestSellersUseCase
import com.example.domain.usecase.hotSales.GetHotSalesUseCase
import com.example.domain.usecase.phones.GetPhoneByIdUseCase
import com.example.models.hotSales.HotSalesResponseModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getPhoneByIdUseCase: GetPhoneByIdUseCase,
    private val getHotSales: GetHotSalesUseCase,
    private val getBestSellers: GetBestSellersUseCase
): ViewModel() {

    fun getHotsales(): LiveData<List<HotSalesResponseModel>> {
        return liveData {
            val data = getHotSales()
            data.body()?.let { emit(it) }
        }
    }

    fun getBestsellers(): LiveData<List<BestSellersResponseModel>> {
        return liveData {
            val data = getBestSellers()
            data.body()?.let { emit(it) }
        }
    }

    fun getPhoneById(id: String): LiveData<PhoneResponseModel> {
        return liveData {
            val data = getPhoneByIdUseCase(id)
            data.body()?.let { emit(it) }
        }
    }
}