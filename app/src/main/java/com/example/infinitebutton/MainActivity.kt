package com.example.infinitebutton

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val xAxisAreaCount = 4
        val yAxisAreaCount = 7

        data class Rect(
            val left: Int,
            val top: Int,
            val width: Float,
            val height: Float
        )

        val isFilledMap = Array(xAxisAreaCount) { Array(yAxisAreaCount) { false } }
        val buttonMap = ArrayList<Rect>()

        (0 until xAxisAreaCount).forEach { x->
            (0 until yAxisAreaCount).forEach { y->
                val isFilled = isFilledMap[x][y]
                if(!isFilled){

                    fun getMaxX(): Int {
                        var max = x
                        while(!isFilledMap[max][y] && max < xAxisAreaCount-1){ max++ }
                        if(isFilledMap[max][y]) max--
                        return max
                    }

                    fun getMaxY(): Int {
                        var max = y
                        while(!isFilledMap[x][max] && max < yAxisAreaCount-1){ max++ }
                        if(isFilledMap[x][max]) max--
                        return max
                    }

                    val randomWidth = (0 .. getMaxX() - x).random() + 1
                    val randomHeight = (0 .. getMaxY() - y).random() + 1

                    buttonMap.add(
                        Rect(
                            x, y, randomWidth.toFloat(), randomHeight.toFloat()
                        )
                    )

                    (x until x+randomWidth).forEach { fillX->
                        (y until y+randomHeight).forEach { fillY->
                            isFilledMap[fillX][fillY] = true
                        }
                    }
                }
            }
        }

        setContent {
            val configuration = LocalConfiguration.current
            val cm = configuration.screenWidthDp.dp/xAxisAreaCount

            Box(modifier = Modifier.fillMaxSize()){
                buttonMap.forEach {
                    Text(
                        text = "${it.width} * ${it.height}",
                        modifier = Modifier
                            .size(cm*it.width, cm*it.height)
                            .padding(8.dp)
                            .offset(
                                cm*it.left, cm*it.top,
                            )
                            .background(Color.Gray)
                            .clickable {  }
                    )
                }
            }
        }
    }
}