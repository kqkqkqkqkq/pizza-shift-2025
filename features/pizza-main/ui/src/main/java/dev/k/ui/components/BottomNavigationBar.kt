package dev.k.ui.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import dev.k.ui.navigation.Screen
import dev.k.ui_kit.PizzaTheme

@Composable
fun BottomNavigationBar(
    navController: NavHostController
) {
    val screens = listOf(
        Screen.Pizza,
        Screen.Orders,
        Screen.Cart,
        Screen.Profile,
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(
        containerColor = PizzaTheme.colorScheme.background
    ) {
        screens.forEach {
            BottomBarItem(
                screen = it,
                currentDestination = currentDestination,
                navController = navController,
            )
        }
    }
}

@Composable
fun RowScope.BottomBarItem(
    screen: Screen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    NavigationBarItem(
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = PizzaTheme.colorScheme.primary,
            unselectedIconColor = PizzaTheme.colorScheme.secondary,
            selectedTextColor = PizzaTheme.colorScheme.primary,
            unselectedTextColor = PizzaTheme.colorScheme.secondary,
            indicatorColor = Color.Transparent,
            disabledIconColor = Color.Transparent,
            disabledTextColor = Color.Transparent,
        ),
        label = {
            Text(
                text = screen.title,
                style = PizzaTheme.typography.labelSmall,
            )
        },
        icon = {
            Icon(
                painter = painterResource(id = screen.icon),
                contentDescription = "Bottom navigation",
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(screen.route) {
                    inclusive = true
                    saveState = true
                }
            }
        }
    )
}