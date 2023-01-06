package com.example.data.models.bestSellers

import androidx.room.PrimaryKey
import java.io.Serializable

data class BestSellersResponseModel(
    @PrimaryKey()
    var id: String,
    val idPhone: String,
    val discountPrice: Double

): Serializable