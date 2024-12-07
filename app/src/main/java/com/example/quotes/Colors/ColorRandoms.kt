package com.example.quotes.Colors

import androidx.compose.ui.graphics.Color
import kotlin.random.Random

object ColorRandoms {

   val randomColor = Color(
      red = Random.nextFloat(),
      green = Random.nextFloat(),
      blue = Random.nextFloat(),
      alpha = 1f
   )

}