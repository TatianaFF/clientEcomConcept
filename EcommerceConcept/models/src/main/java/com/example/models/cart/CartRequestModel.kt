package com.example.data.models.cart

import androidx.room.PrimaryKey
import com.example.idUserConst
import java.io.Serializable

data class CartRequestModel(
    @PrimaryKey
    val id: String = "",
    val idUser: String = idUserConst,
    val idPhone: String,
    var count: Int = 1
): Serializable