package com.example.domain.usecase.cart

import com.example.data.models.cart.CartRequestModel
import com.example.data.repository.MainRepository
import com.example.models.cart.CartRequestUpdateModel
import javax.inject.Inject

class UpdateCartUseCase@Inject constructor(private val mainRepository : MainRepository) {
    suspend operator fun invoke(cart: CartRequestUpdateModel) = mainRepository.updateCart(cart)
}