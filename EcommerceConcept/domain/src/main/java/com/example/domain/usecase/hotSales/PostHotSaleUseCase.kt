package com.example.domain.usecase.hotSales

import com.example.data.repository.MainRepository
import com.example.models.hotSales.HotSalesRequestModel
import javax.inject.Inject

class PostHotSaleUseCase@Inject constructor(private val mainRepository : MainRepository) {
    suspend operator fun invoke(hotsale: HotSalesRequestModel) = mainRepository.postHotSale(hotsale)
}