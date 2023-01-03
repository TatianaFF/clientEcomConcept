package com.example.ecommerceconcept.models.bestSellers

import androidx.room.PrimaryKey
import java.io.Serializable

data class BestSellersRequestModel(
    val idPhone: String,
    val discountPrice: Double

): Serializable