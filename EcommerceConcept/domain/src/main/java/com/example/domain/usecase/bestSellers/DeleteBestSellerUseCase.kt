package com.example.domain.usecase.bestSellers

import com.example.data.models.bestSellers.BestSellersRequestModel
import com.example.data.repository.MainRepository
import javax.inject.Inject

class DeleteBestSellerUseCase@Inject constructor(private val mainRepository : MainRepository) {
    suspend operator fun invoke(id: String) = mainRepository.deleteBestSeller(id)
}