package com.example.domain.usecase.hotSales

import com.example.data.repository.MainRepository
import javax.inject.Inject

class DeleteHotSaleUseCase@Inject constructor(private val mainRepository : MainRepository) {
    suspend operator fun invoke(id: String) = mainRepository.deleteHotSale(id)
}