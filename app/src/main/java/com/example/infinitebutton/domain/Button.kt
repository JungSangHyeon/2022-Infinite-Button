package com.example.infinitebutton.domain

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

// border
    // thick
    // color
//text or drawable
    // size
    // color
// shape
// haptick

class Button(
    private val left: Int,
    private val top: Int,
    private val width: Float,
    private val height: Float,
    private val unit: Dp
) {
    @Composable
    fun ComposeButton(click: () -> Unit) {
        Text(
            text = "$width * $height",
            modifier = Modifier
                .size(unit * width, unit * height)
                .padding(8.dp)
                .offset(unit * left, unit * top)
                .background(Color.Gray)
                .clickable { click() }
        )
    }
}