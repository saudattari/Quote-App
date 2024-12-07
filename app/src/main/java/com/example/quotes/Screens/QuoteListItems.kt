package com.example.quotes.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.quotes.Colors.ColorRandoms
import com.example.quotes.Model.Quote
import com.example.quotes.R


@Composable
fun QuoteListItem(data: Quote, onClick: (Quote) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(115.dp)
            .padding(10.dp)
            .clickable(onClick = { onClick(data) }),
        elevation = CardDefaults.cardElevation(8.dp),
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth()
        ) {
            Image(
                imageVector = Icons.Default.FormatQuote,
                contentDescription = "Quote Icon",
                colorFilter = ColorFilter.tint(Color.White),
                modifier = Modifier
                    .background(ColorRandoms.randomColor)
                    .rotate(180f),
                alignment = Alignment.TopStart
            )
            Spacer(modifier = Modifier.width(8.dp))

            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = data.text,
                    fontWeight = FontWeight.W400,
                    maxLines = 2,
                    fontFamily = FontFamily(Font(R.font.roboto_regular))
                )
                Spacer(modifier = Modifier.height(8.dp))
                Box(
                    modifier = Modifier
                        .height(1.dp)
                        .width(60.dp)
                        .background(Color.Gray)
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = data.author,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                )
            }
        }
    }
}


