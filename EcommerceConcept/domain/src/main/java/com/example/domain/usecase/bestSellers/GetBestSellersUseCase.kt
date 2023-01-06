package com.example.domain.usecase.bestSellers

import com.example.data.repository.MainRepository
import javax.inject.Inject

class GetBestSellersUseCase@Inject constructor(private val mainRepository : MainRepository) {
    suspend operator fun invoke() = mainRepository.getBestSellers()
}