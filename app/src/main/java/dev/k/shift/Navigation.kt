package dev.k.shift

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import dev.k.ui.cartScreenNavigation
import dev.k.ui.ordersScreenNavigation
import dev.k.ui.pizzaDetailNavigation
import dev.k.ui.pizzaScreenNavigation
import dev.k.ui.profileScreenNavigation
import dev.k.ui_kit.Destinations
import dev.k.ui_kit.theme.ShiftTheme

@Composable
fun Navigation() {
    ShiftTheme {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = Destinations.PIZZA_SCREEN,
        ) {
            pizzaScreenNavigation(navController)
            profileScreenNavigation(navController)
            pizzaDetailNavigation(navController)
            ordersScreenNavigation(navController)
            cartScreenNavigation(navController)
        }
    }
}