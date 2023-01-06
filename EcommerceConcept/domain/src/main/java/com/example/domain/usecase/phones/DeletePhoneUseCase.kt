package com.example.domain.usecase.phones

import com.example.data.repository.MainRepository
import javax.inject.Inject

class DeletePhoneUseCase@Inject constructor(private val mainRepository : MainRepository) {
    suspend operator fun invoke(id: String) = mainRepository.deletePhone(id)
}