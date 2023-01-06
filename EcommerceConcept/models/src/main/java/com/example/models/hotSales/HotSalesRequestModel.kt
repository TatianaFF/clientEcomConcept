package com.example.models.hotSales

import java.io.Serializable

data class HotSalesRequestModel(
    val idPhone: String,
    val isNew: Boolean = false,
    val subTitle: String,
    val picture: String

): Serializable