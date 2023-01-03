package com.example.ecommerceconcept.models.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*

class ConverterListString {
    private val gson = Gson()
    @TypeConverter
    fun stringToList(data: String?): List<String> {
        return if (data == null) {
            Collections.emptyList()
        } else {
            val listType = object : TypeToken<List<String>>() {

            }.type

            gson.fromJson(data, listType)
        }
    }

    @TypeConverter
    fun listToString(someObjects: List<String>): String {
        return gson.toJson(someObjects)
    }
}