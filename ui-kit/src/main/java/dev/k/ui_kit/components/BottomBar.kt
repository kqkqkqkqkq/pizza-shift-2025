package dev.k.ui_kit.components

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
import dev.k.ui_kit.theme.PizzaTheme

@Composable
fun BottomNavigationBar(
    navController: NavHostController,
) {
    val bottomBarScreens = listOf(
        BottomBarScreen.BottomBarPizza,
        BottomBarScreen.BottomBarOrders,
        BottomBarScreen.BottomBarCart,
        BottomBarScreen.BottomBarProfile,
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(
        containerColor = PizzaTheme.colorScheme.background
    ) {
        bottomBarScreens.forEach {
            BottomBarItem(
                bottomBarScreen = it,
                currentDestination = currentDestination,
                navController = navController,
            )
        }
    }
}

@Composable
fun RowScope.BottomBarItem(
    bottomBarScreen: BottomBarScreen,
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
                text = bottomBarScreen.title,
                style = PizzaTheme.typography.labelSmall,
            )
        },
        icon = {
            Icon(
                painter = painterResource(id = bottomBarScreen.icon),
                contentDescription = "Bottom navigation",
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == bottomBarScreen.route
        } == true,
        onClick = {
            if (currentDestination?.route != bottomBarScreen.route) {
                navController.navigate(bottomBarScreen.route) {
                    popUpTo(bottomBarScreen.route) {
                        inclusive = true
                        saveState = true
                    }
                }
            }
        }
    )
}