package dev.k.ui

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import dev.k.ui_kit.Destinations

fun NavGraphBuilder.makeOrderCardDataScreenNavigation(
    navController: NavHostController,
) {
    composable(Destinations.MAKE_ORDER_CARD_DATA_SCREEN) {
        MakeOrderCardScreen(navController)
    }
}