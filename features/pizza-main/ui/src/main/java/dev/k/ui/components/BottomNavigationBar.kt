package dev.k.ui.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import dev.k.ui.navigation.Screen

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
        containerColor = Color.Blue.copy(alpha = 0.4f)
    ) {
        screens.forEach {
            AddItem(
                screen = it,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: Screen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    NavigationBarItem(
        colors = NavigationBarItemColors(
            selectedIconColor = Color.Black,
            unselectedIconColor = Color.Yellow,
            selectedTextColor = Color.Black,
            selectedIndicatorColor = Color.Transparent,
            unselectedTextColor = Color.Black,
            disabledIconColor = Color.Red,
            disabledTextColor = Color.Red,
        ),
        label = {
            Text(
                text = screen.title,
//                fontFamily = poppins_light,
                fontSize = 12.sp,
//                color = surfaceColor
            )
        },
        icon = {
            Icon(
                painter = painterResource(id = screen.icon),
                contentDescription = "BottomNavigationIcon",
            )
        },
        selected = currentDestination?.hierarchy?.any{
            it.route == screen.route
        } == true,
        onClick = {
            navController.navigate(screen.route){
                popUpTo(screen.route) {
                    inclusive = true
                    saveState = true
                }
            }
        }
    )
}