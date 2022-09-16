package com.example.infinitebutton.domain

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.example.infinitebutton.tech.forAllCombination

class ButtonPlate(
    private val width: Int,
    private val height: Int,
    private val unit: Dp
) {
    private val buttons = mutableStateOf<ArrayList<Button>?>(null)

    init {
        updateButtons()
    }

    @Composable
    fun ComposeButtonPlate() = Box(
        modifier = Modifier
            .background(Color.Black)
            .size(unit * width, unit * height)
    ) {
        buttons.value?.forEach {
            it.ComposeButton {
                updateButtons()
            }
        }
    }

    fun updateButtons() {
        val newButtons = ArrayList<Button>()
        val isFilled = Array(width) { Array(height) { false } }

        forAllCombination(
            (0 until width),
            (0 until height)
        ) { x, y ->
            if (!isFilled[x][y]) {

                fun getMaxX(): Int {
                    var max = x
                    while (!isFilled[max][y] && max < width - 1) max++
                    if (isFilled[max][y]) max--
                    return max
                }

                fun getMaxY(): Int {
                    var max = y
                    while (!isFilled[x][max] && max < height - 1) max++
                    if (isFilled[x][max]) max--
                    return max
                }

                val randomWidth = (0..getMaxX() - x).random() + 1
                // 디자인을 위해, 세로가 가로보다 긴 경우를 없게 함.
                val randomHeight = (0..(getMaxY() - y).coerceAtMost(randomWidth - 1)).random() + 1

                newButtons.add(
                    Button(x, y, randomWidth.toFloat(), randomHeight.toFloat(), unit)
                )

                forAllCombination(
                    (x until x + randomWidth),
                    (y until y + randomHeight)
                ) { fillX, fillY ->
                    isFilled[fillX][fillY] = true
                }
            }
        }
        buttons.value = newButtons
    }
}