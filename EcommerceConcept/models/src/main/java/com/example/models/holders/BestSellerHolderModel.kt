package com.example.models.holders

import java.io.Serializable

data class BestSellerHolderModel(
    val id: String,
    val discount_price: Double? = null,
    val picture: String,
    val price_without_discount: Double,
    val title: String
): Serializable