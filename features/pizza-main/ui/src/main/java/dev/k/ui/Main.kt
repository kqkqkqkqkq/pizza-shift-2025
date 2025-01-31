package dev.k.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import dev.k.ui.navigation.NavGraph

@Composable
fun Main() {
    val navController = rememberNavController()
    NavGraph(navController)
}