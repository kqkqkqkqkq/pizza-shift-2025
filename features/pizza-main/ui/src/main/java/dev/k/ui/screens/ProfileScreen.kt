package dev.k.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import dev.k.ui.components.BottomNavigationBar

@Composable
fun ProfileScreen(
    navController: NavHostController,
) {
    ProfileScreenContent(navController = navController)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
internal fun ProfileScreenContent(
    navController: NavHostController,
) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text("Профиль")
        }
    }
}