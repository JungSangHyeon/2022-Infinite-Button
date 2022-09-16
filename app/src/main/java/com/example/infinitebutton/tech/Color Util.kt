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

    fun composeBrightColor() = Color(brightColor())

    fun brightColor() = listOf(
        0xfff44336,0xffe91e63,0xff9c27b0,0xff673ab7,
        0xff3f51b5,0xff2196f3,0xff03a9f4,0xff00bcd4,
        0xff009688,0xff4caf50,0xff8bc34a,0xffcddc39,
        0xffffeb3b,0xffffc107,0xffff9800,0xffff5722
    ).random()
}
