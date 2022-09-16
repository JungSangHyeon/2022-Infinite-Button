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
import androidx.compose.ui.graphics.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.graphics.ColorUtils
import com.example.infinitebutton.R
import com.example.infinitebutton.tech.ColorUtil

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

    private val borderThick = (1..10).random()
    private val content = contentList.random()
    private val borderAndContentColor = ColorUtil.composeBrightColor()

    private val backgroundColor = Color(ColorUtils.blendARGB(borderAndContentColor.toArgb(), Color.White.toArgb(), 0.65f))

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
                painter = painterResource(id = content),
                contentDescription = null,
                colorFilter = ColorFilter.tint(borderAndContentColor),
                modifier = Modifier
                    .size(unit * height)
                    .padding(16.dp)
            )
        }
    }
}

private val contentList = listOf(
    R.drawable.ic_baseline_123_24,
    R.drawable.ic_baseline_all_inclusive_24,
    R.drawable.ic_baseline_arrow_circle_up_24,
    R.drawable.ic_baseline_call_24,
    R.drawable.ic_baseline_center_focus_weak_24,
    R.drawable.ic_baseline_directions_run_24,
    R.drawable.ic_baseline_done_24,
    R.drawable.ic_baseline_exposure_plus_1_24,
    R.drawable.ic_baseline_fingerprint_24,
    R.drawable.ic_baseline_flight_24,
    R.drawable.ic_baseline_format_shapes_24,
    R.drawable.ic_baseline_front_hand_24,
    R.drawable.ic_baseline_keyboard_voice_24,
    R.drawable.ic_baseline_message_24,
    R.drawable.ic_baseline_mood_24,
    R.drawable.ic_baseline_person_add_24,
    R.drawable.ic_baseline_thumb_up_24
)