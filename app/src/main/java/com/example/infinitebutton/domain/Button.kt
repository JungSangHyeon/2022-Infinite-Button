package com.example.infinitebutton.domain

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.infinitebutton.R
import com.example.infinitebutton.tech.ColorUtil

// TODO haptick, content

class Button(
    private val left: Int,
    private val top: Int,
    private val width: Float,
    private val height: Float,
    private val unit: Dp
) {

    enum class ShapeType(
        val composeShape: Shape
    ) {
        RECT(RectangleShape),
        ROUND_RECT(RoundedCornerShape(20)),
        CIRCLE(CircleShape)
    }

    private val shape = ShapeType.values().random()

    private val borderThick = (0..10).random()

    private val backgroundColor = ColorUtil.randomComposeColor()
    private val borderAndContentColor = ColorUtil.randomComposeColor()

    @Composable
    fun ComposeButton(click: () -> Unit) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(unit * width, unit * height)
                .padding(8.dp)
                .offset(unit * left, unit * top)
                .clip(shape.composeShape)
                .background(backgroundColor, shape.composeShape)
                .border(borderThick.dp, borderAndContentColor, shape.composeShape)
                .clickable { click() }
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null
            )
        }
    }
}