package dev.k.shift

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
//        enableEdgeToEdge(
//            statusBarStyle = SystemBarStyle.auto(
//                lightScrim = Color.TRANSPARENT, darkScrim = Color.TRANSPARENT,
//            ),
//            navigationBarStyle = SystemBarStyle.auto(
//                lightScrim = Color.TRANSPARENT, darkScrim = Color.TRANSPARENT,
//            )
//        )
        super.onCreate(savedInstanceState)
        setContent {
            Navigation()
        }
    }
}