package com.example.infinitebutton.tech

import androidx.compose.ui.graphics.Color

object ColorUtil{

    fun randomComposeColor() = Color(randomColor())

    fun randomColor() = android.graphics.Color.argb(
        255,
        (0 until 255).random(),
        (0 until 255).random(),
        (0 until 255).random()
    )
}
