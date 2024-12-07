package com.example.quotes.Screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.quotes.Model.Quote


@Composable
fun ListItemScreen(data: Array<Quote>, onClick: (Quote) -> Unit) {
    LazyColumn(content = {
        items(data) { it ->
            QuoteListItem(it) {
                onClick(it)
            }
        }
    }, modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 20.dp))
}