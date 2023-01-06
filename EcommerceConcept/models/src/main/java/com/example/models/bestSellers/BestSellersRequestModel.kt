package com.example.data.models.bestSellers

import java.io.Serializable

data class BestSellersRequestModel(
    val idPhone: String,
    val discountPrice: Double

): Serializable