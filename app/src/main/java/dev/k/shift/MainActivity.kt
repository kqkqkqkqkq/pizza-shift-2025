package dev.k.shift

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dev.k.shift.ui.theme.ShiftTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShiftTheme {
                /**
                 * Dependencies:
                 * Retrofit, Room(for caching)?, Kotlinx-serialization,
                 * Dagger+Hilt, Coroutines
                 */
            }
        }
    }
}