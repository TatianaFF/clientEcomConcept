package com.example.domain.usecase.phones

import com.example.data.repository.MainRepository
import javax.inject.Inject

class GetPhoneByIdUseCase @Inject constructor(private val mainRepository : MainRepository) {
    suspend operator fun invoke(id: String) = mainRepository.getPhoneById(id)
}