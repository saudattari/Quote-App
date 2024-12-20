package com.example.quotes.Screens


import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.ClipboardManager
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.quotes.Colors.ColorRandoms
import com.example.quotes.Model.Quote
import com.example.quotes.R



@Composable
fun QuoteDetail(data: Quote, onBack: () -> Unit) {
    val clipboardManager: ClipboardManager = LocalClipboardManager.current
    val context = LocalContext.current
    BackHandler {
        onBack()
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.sweepGradient(
                    colors = listOf(Color(color = 0xFFffffff), Color(color = 0xFFe3e3e3))
                )
            )
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .align(Alignment.Center)
                .padding(20.dp, 40.dp),
            elevation = CardDefaults.cardElevation(25.dp),
        ) {
            Row(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    imageVector = Icons.Default.FormatQuote,
                    contentDescription = "",
                    modifier = Modifier
                        .background(ColorRandoms.randomColor())
                        .rotate(180f),
                    colorFilter = ColorFilter.tint(Color.White)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column(Modifier.fillMaxWidth()) {
                    Text(
                        text = data.text,
                        maxLines = Int.MAX_VALUE,
                        fontFamily = FontFamily(Font(R.font.roboto_regular)),
                        fontWeight = FontWeight.W400
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Box(
                        modifier = Modifier
                            .background(Color.Gray)
                            .width(60.dp)
                            .height(1.dp)
                    ) { }
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = data.author, fontWeight = FontWeight.Bold)

                }

            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp, 0.dp, 10.dp, 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    imageVector = Icons.Default.ContentCopy,
                    contentDescription = "Copy Text",
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                            clipboardManager.setText(
                                annotatedString = androidx.compose.ui.text.AnnotatedString(
                                    "*Quote:* \n" + data.text + "\n\n*Author:*\n" + data.author
                                )
                            )
                            Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show()
                        }
                )
                Image(
                    painter = painterResource(id = R.drawable.back_arrow),
                    contentDescription = "Back Event Button",
                    modifier = Modifier
                        .size(24.dp)
                        .clickable(onClick = { onBack() })
                )

            }
        }

    }
}