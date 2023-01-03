package com.example.ecommerceconcept.models.bestSellers

import androidx.room.PrimaryKey
import java.io.Serializable

data class BestSellersResponseModel(
    @PrimaryKey
    var id: String,
    val idPhone: String,
    val discountPrice: Double

): Serializable