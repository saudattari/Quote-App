package com.example.quotes.Screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.quotes.Model.Quote


@Composable
fun ListItemScreen(data: Array<Quote>, onClick: (Quote) -> Unit) {
    LazyColumn(content = {
        items(data) {
            QuoteListItem(it){
                onClick(it)
            }
        }
    })


}