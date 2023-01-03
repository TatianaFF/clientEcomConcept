package com.example.ecommerceconcept.models.cart

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.ecommerceconcept.idUserConst
import java.io.Serializable

data class CartRequestModel(
    val idUser: String = idUserConst,
    val idPhone: String,
    var count: Int = 1
): Serializable