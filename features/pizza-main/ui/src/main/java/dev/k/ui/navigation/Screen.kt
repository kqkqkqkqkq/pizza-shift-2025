package dev.k.ui.navigation

import dev.k.ui_kit.R

sealed class Screen(
    val route: String,
    val title: String,
    val icon: Int,
) {
    data object Pizza : Screen(
        route = "pizza",
        title = "Пицца",
        icon = R.drawable.icon_pizza,
    )

    data object Orders : Screen(
        route = "orders",
        title = "Заказы",
        icon = R.drawable.icon_time,
    )

    data object Cart : Screen(
        route = "cart",
        title = "Корзина",
        icon = R.drawable.icon_trash,
    )

    data object Profile : Screen(
        route = "profile",
        title = "Профиль",
        icon = R.drawable.icon_user,
    )

    companion object {
        const val PIZZA_DETAIL = "pizza_detail"
    }
}