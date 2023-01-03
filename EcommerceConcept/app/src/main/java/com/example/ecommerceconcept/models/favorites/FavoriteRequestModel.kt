package com.example.ecommerceconcept.models.favorites

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.ecommerceconcept.idUserConst
import java.io.Serializable

data class FavoriteRequestModel(
    val idUser: String = idUserConst,
    val idPhone: String
): Serializable