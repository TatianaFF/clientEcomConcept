package com.example.domain.usecase.cart

import com.example.data.models.cart.CartRequestModel
import com.example.data.repository.MainRepository
import javax.inject.Inject

class PostCartUseCase@Inject constructor(private val mainRepository : MainRepository) {
    suspend operator fun invoke(cart: CartRequestModel) = mainRepository.postCart(cart)
}