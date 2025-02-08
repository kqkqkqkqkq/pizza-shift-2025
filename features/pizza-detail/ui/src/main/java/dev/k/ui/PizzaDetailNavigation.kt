package dev.k.ui

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import dev.k.ui_kit.Destinations
import dev.k.ui_utils.models.PizzaUI


fun NavGraphBuilder.pizzaDetailNavigation(
    navController: NavHostController,
) {
    composable(Destinations.PIZZA_DETAIL_SCREEN) {
        val pizza =
            navController.previousBackStackEntry?.savedStateHandle?.get<PizzaUI>("pizzaUI")!!
        PizzaDetailScreen(pizza, navController)
    }
}