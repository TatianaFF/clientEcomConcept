package com.example.domain.usecase.favorites

import com.example.data.repository.MainRepository
import javax.inject.Inject

class GetFavoritesByIdUserUseCase@Inject constructor(private val mainRepository : MainRepository) {
    suspend operator fun invoke(id: String) = mainRepository.getFavoritesByIdUser(id)

}