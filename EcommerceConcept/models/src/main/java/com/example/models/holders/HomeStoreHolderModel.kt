package com.example.data.models.holders

import java.io.Serializable

data class HomeStoreHolderModel(
    val id: String,
    val is_new: Boolean,
    val image: String,
    val description: String,
    val brand: String
):Serializable