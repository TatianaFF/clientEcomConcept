package com.example.domain.usecase.hotSales

import com.example.data.repository.MainRepository
import javax.inject.Inject

class GetHotSalesUseCase@Inject constructor(private val mainRepository : MainRepository) {
    suspend operator fun invoke() = mainRepository.getHotsales()
}