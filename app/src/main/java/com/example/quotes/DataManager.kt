package com.example.quotes

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.quotes.Model.Quote
import com.google.gson.Gson

object DataManager {

    var data = emptyArray<Quote>()
//    var isLoaded  = false
    fun ReadQuotes(context: Context) {
        val inputStream = context.assets.open("Quotes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer,Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<Quote>::class.java)
    }
}