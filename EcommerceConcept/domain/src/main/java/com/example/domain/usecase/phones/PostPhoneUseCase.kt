package com.example.domain.usecase.phones

import com.example.data.models.phones.PhoneRequestModel
import com.example.data.repository.MainRepository
import javax.inject.Inject

class PostPhoneUseCase@Inject constructor(private val mainRepository : MainRepository) {
    suspend operator fun invoke(phone: PhoneRequestModel) = mainRepository.postPhone(phone)
}