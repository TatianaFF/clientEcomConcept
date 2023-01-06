package com.example.domain.usecase.favorites

import com.example.data.models.favorites.FavoriteRequestModel
import com.example.data.repository.MainRepository
import javax.inject.Inject

class PostFavoriteUseCase@Inject constructor(private val mainRepository : MainRepository) {
    suspend operator fun invoke(favorite: FavoriteRequestModel) = mainRepository.postFavorite(favorite)

}