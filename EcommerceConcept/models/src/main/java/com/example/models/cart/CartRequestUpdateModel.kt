package com.example.models.cart

import androidx.room.PrimaryKey
import com.example.idUserConst
import java.io.Serializable

data class CartRequestUpdateModel(
    @PrimaryKey
    val id: String,
    val idUser: String = idUserConst,
    val idPhone: String,
    var count: Int = 1
): Serializable