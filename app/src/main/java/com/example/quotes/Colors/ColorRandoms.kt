package com.example.quotes.Colors

import androidx.compose.ui.graphics.Color
import kotlin.random.Random

object ColorRandoms {
      fun randomColor(): Color {
         return Color(
            red = Random.nextFloat(),
            green = Random.nextFloat(),
            blue = Random.nextFloat(),
            alpha = 1f
         )
      }

}