package dev.k.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.k.ui_logic.models.PizzaUI
import dev.k.ui.screens.CartScreen
import dev.k.ui.screens.OrdersScreen
import dev.k.ui.screens.PizzaDetailScreen
import dev.k.ui.screens.PizzaScreen
import dev.k.ui.screens.ProfileScreen

@Composable
fun NavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Pizza.route,
    ) {
        composable(Screen.Pizza.route) {
            PizzaScreen(navController)
        }
        composable(Screen.Orders.route) {
            OrdersScreen(navController)
        }
        composable(Screen.Cart.route) {
            CartScreen(navController)
        }
        composable(Screen.Profile.route) {
            ProfileScreen(navController)
        }
        composable(Screen.PIZZA_DETAIL) {
            val pizza = navController.previousBackStackEntry?.savedStateHandle?.get<PizzaUI>("pizzaUI")!!
            PizzaDetailScreen(pizza, navController)
        }
    }
}