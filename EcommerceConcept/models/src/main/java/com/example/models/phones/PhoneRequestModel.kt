package com.example.data.models.phones

import androidx.room.TypeConverters
import com.example.models.converters.ConverterListString
import java.io.Serializable

data class PhoneRequestModel(
    val CPU: String,
    val camera: String,
    @TypeConverters(ConverterListString::class)
    val capacity: List<String>,
    @TypeConverters(ConverterListString::class)
    val color: List<String>,
    @TypeConverters(ConverterListString::class)
    val images: List<String>,
    val price: Double,
    val rating: Double? = null,
    val ssd: String,
    val title: String
) : Serializable