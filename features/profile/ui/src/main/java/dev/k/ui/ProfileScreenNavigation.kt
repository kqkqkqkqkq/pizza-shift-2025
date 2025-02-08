package dev.k.ui

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import dev.k.ui_kit.Destinations

fun NavGraphBuilder.profileScreenNavigation(
    navController: NavHostController,
) {
    composable(Destinations.PROFILE_SCREEN) {
        ProfileScreen(navController)
    }
}