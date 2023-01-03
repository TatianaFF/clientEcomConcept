package com.example.ecommerceconcept.models.hotSales

import androidx.room.Entity
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