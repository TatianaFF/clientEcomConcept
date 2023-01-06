package com.example.data.models.favorites

import com.example.idUserConst
import java.io.Serializable

data class FavoriteRequestModel(
    val idUser: String = idUserConst,
    val idPhone: String
): Serializable