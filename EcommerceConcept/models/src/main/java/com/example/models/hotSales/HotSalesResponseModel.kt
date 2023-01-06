package com.example.models.hotSales

import androidx.room.PrimaryKey
import java.io.Serializable

data class HotSalesResponseModel(
    @PrimaryKey
    var id: String,
    val idPhone: String,
    val isNew: Boolean = false,
    val subTitle: String,
    val picture: String

): Serializable