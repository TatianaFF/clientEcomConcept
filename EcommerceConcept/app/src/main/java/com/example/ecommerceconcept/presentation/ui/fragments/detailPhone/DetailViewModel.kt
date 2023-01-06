package com.example.ecommerceconcept.presentation.ui.fragments.detailPhone

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.data.models.bestSellers.BestSellersResponseModel
import com.example.data.models.cart.CartRequestModel
import com.example.data.models.cart.CartResponseModel
import com.example.data.models.favorites.FavoriteRequestModel
import com.example.data.models.phones.PhoneResponseModel
import com.example.domain.usecase.bestSellers.GetBestSellerByIdUseCase
import com.example.domain.usecase.cart.DeleteCartUseCase
import com.example.domain.usecase.cart.GetCartsUseCase
import com.example.domain.usecase.cart.PostCartUseCase
import com.example.domain.usecase.favorites.PostFavoriteUseCase
import com.example.domain.usecase.phones.GetPhoneByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getPhoneByIdUC: GetPhoneByIdUseCase,
    private val getBestSellerByIdUC: GetBestSellerByIdUseCase,
    private val postCart: PostCartUseCase,
    private val postFavorite: PostFavoriteUseCase,
    private val getCartsUC: GetCartsUseCase

): ViewModel() {

    fun getCarts(): LiveData<List<CartResponseModel>> {
        return liveData {
            val data = getCartsUC()
            data.body()?.let { emit(it) }
        }
    }

    fun getPhoneById(id: String): LiveData<PhoneResponseModel> {
        return liveData {
            val data = getPhoneByIdUC(id)
            data.body()?.let { emit(it) }
        }
    }

    fun getBestSellerById(id: String): LiveData<BestSellersResponseModel> {
        return liveData {
            val data = getBestSellerByIdUC(id)
            data.body()?.let { emit(it) }
        }
    }

    fun insertCart(cart: CartRequestModel) {
        viewModelScope.launch {
            postCart(cart)
        }
    }

    fun insertFavorite(favorite: FavoriteRequestModel) {
        viewModelScope.launch {
            postFavorite(favorite)
        }
    }

}