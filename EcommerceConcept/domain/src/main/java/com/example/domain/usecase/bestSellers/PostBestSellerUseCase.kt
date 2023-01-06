package com.example.domain.usecase.bestSellers

import com.example.data.models.bestSellers.BestSellersRequestModel
import com.example.data.repository.MainRepository
import javax.inject.Inject

class PostBestSellerUseCase@Inject constructor(private val mainRepository : MainRepository) {
    suspend operator fun invoke(bestseller: BestSellersRequestModel) = mainRepository.postBestSeller(bestseller)
}