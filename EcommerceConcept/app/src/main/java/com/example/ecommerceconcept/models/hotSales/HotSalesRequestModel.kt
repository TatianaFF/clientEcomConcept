package com.example.ecommerceconcept.models.hotSales

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

data class HotSalesRequestModel(
    val idPhone: String,
    val isNew: Boolean = false,
    val subTitle: String,
    val picture: String

): Serializable