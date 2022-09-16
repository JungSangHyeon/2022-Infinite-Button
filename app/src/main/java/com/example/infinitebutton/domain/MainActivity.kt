package com.example.infinitebutton.domain

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.example.infinitebutton.tech.ColorUtil

class MainActivity : ComponentActivity() {

    companion object {
        private val buttonPlateSize = IntSize(4, 6)
    }

    private var buttonPlate: ButtonPlate? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val configuration = LocalConfiguration.current

            LaunchedEffect("Launch Only Once") {
                buttonPlate = ButtonPlate(
                    buttonPlateSize.width,
                    buttonPlateSize.height,
                    configuration.screenWidthDp.dp / buttonPlateSize.width
                )
            }

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                buttonPlate?.ComposeButtonPlate()
            }
        }
    }
}


