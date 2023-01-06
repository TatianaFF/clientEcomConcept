package com.example.domain.usecase.favorites

import com.example.data.repository.MainRepository
import javax.inject.Inject

class GetFavoritesUseCase@Inject constructor(private val mainRepository : MainRepository) {
    suspend operator fun invoke() = mainRepository.getFavorites()

}