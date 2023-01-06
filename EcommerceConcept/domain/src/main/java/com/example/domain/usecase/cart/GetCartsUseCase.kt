package com.example.domain.usecase.cart

import com.example.data.repository.MainRepository
import javax.inject.Inject

class GetCartsUseCase@Inject constructor(private val mainRepository : MainRepository) {
    suspend operator fun invoke() = mainRepository.getCarts()
}