package com.example.ecommerceconcept.presentation.ui.activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.data.models.cart.CartResponseModel
import com.example.domain.usecase.cart.GetCartUseCase
import com.example.domain.usecase.cart.GetCartsByIdUserUseCase
import com.example.domain.usecase.cart.GetCartsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val getCartsByIdUserUC: GetCartsByIdUserUseCase
): ViewModel() {

    fun getCartsByIdUser(id: String): LiveData<List<CartResponseModel>> {
        return liveData {
            val data = getCartsByIdUserUC(id)
            data.body()?.let { emit(it) }
        }
    }

}