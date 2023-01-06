package com.example.data.models.favorites

import androidx.room.PrimaryKey
import com.example.idUserConst
import java.io.Serializable

data class FavoriteResponseModel(
    @PrimaryKey()
    var id: String,
    val idUser: String = idUserConst,
    val idPhone: String
): Serializable