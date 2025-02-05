package dev.k.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import dev.k.ui.R
import dev.k.ui.components.BottomNavigationBar

@Composable
fun ProfileScreen(
    navController: NavHostController,
) {
    ProfileScreenContent(navController = navController)
}

@Composable
internal fun ProfileScreenContent(
    navController: NavHostController,
) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    bottom = padding.calculateBottomPadding(),
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(stringResource(R.string.profile))
        }
    }
}