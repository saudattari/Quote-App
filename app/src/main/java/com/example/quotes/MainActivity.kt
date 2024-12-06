package com.example.quotes

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quotes.Model.Quote
import com.example.quotes.Screens.ListItemScreen
import com.example.quotes.Screens.QuoteDetail
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        CoroutineScope(Dispatchers.IO).launch {
//            DataManager.ReadQuotes(applicationContext)
//        }
        enableEdgeToEdge()
        setContent {
            var isLoaded by remember { mutableStateOf(false) }
            LaunchedEffect(Unit) {
                CoroutineScope(Dispatchers.IO).launch {
                    DataManager.ReadQuotes(applicationContext)
                    delay(2000)
                    isLoaded = true
                }
            }
            if (isLoaded) {
                AppRun()
            } else {
                LoadingScreen()
            }

        }
    }

    @Preview(showBackground = true)
    @Composable
    fun LoadingScreen() {
        Box(modifier = Modifier.fillMaxSize().background(Color.Black)) {
            Text(
                text = "Quote App",
                fontSize = 40.sp, color = Color.White,
                modifier = Modifier
                    .align(alignment = Alignment.Center)
                    ,
                fontFamily = FontFamily.Cursive
            )

        }
    }

    @Composable
    fun AppRun() {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Quote App",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(0.dp, 30.dp)
                        .fillMaxWidth(),
                    fontSize = 30.sp,
                    fontFamily = FontFamily.Cursive
                )
                Spacer(modifier = Modifier.height(4.dp))
                App()
                Spacer(modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 15.dp))
            }

        }

    }

    private @Composable
    fun App() {
        val data1 = DataManager.data
        ListItemScreen(data1) { quote ->
            val intent = Intent(this, QuoteDetailActivity::class.java).apply {
                putExtra("Quote Text", quote.text)
                putExtra("Quote Author", quote.author)
            }
            startActivity(intent)
        }
    }

}
