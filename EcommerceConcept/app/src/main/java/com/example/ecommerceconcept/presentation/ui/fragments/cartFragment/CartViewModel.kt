package com.example.ecommerceconcept.presentation.ui.fragments.cartFragment

import androidx.lifecycle.*
import com.example.data.models.cart.CartRequestModel
import com.example.data.models.cart.CartResponseModel
import com.example.data.models.phones.PhoneResponseModel
import com.example.domain.usecase.cart.*
import com.example.domain.usecase.phones.GetPhoneByIdUseCase
import com.example.models.cart.CartRequestUpdateModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val deleteCartUC: DeleteCartUseCase,
    private val getCartsByIdUserUC: GetCartsByIdUserUseCase,
    private val postCartUC: PostCartUseCase,
    private val updateCartUC: UpdateCartUseCase,
    private val getPhoneByIdUC: GetPhoneByIdUseCase,
    private val getCartsUC: GetCartsUseCase

): ViewModel() {

    fun getCarts(): LiveData<List<CartResponseModel>> {
        return liveData {
            val data = getCartsUC()
            data.body()?.let { emit(it) }
        }
    }

    fun getCartsByIdUser(id: String): LiveData<List<CartResponseModel>> {
        return liveData {
            val data = getCartsByIdUserUC(id)
            data.body()?.let { emit(it) }
        }
    }

    fun deleteCart(id: String) {
        viewModelScope.launch {
            deleteCartUC(id)
        }
    }

    fun insertCart(cart: CartRequestModel) {
        viewModelScope.launch {
            postCartUC(cart)
        }
    }

    fun updateCart(cart: CartRequestUpdateModel) {
        viewModelScope.launch {
            updateCartUC(cart)
        }
    }

    fun getPhoneById(id: String): LiveData<PhoneResponseModel> {
        return liveData {
            val data = getPhoneByIdUC(id)
            data.body()?.let { emit(it) }
        }
    }

}