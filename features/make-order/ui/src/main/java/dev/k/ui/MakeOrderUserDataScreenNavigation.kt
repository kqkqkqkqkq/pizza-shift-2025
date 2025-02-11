package dev.k.ui

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import dev.k.ui_kit.Destinations

fun NavGraphBuilder.makeOrderUserDataScreenNavigation(
    navController: NavHostController,
) {
    composable(Destinations.MAKE_ORDER_USER_DATA_SCREEN) {
        MakeOrderUserScreen(navController)
    }
}