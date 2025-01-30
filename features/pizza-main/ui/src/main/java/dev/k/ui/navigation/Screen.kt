package dev.k.ui.navigation

import dev.k.ui.R

sealed class Screen(
    val route: String,
    val title: String,
    val icon: Int,
) {
    object Pizza: Screen(
        route = "pizza",
        title = "Пицца",
        icon = R.drawable.icon_pizza,
    )

    object Orders: Screen(
        route = "orders",
        title = "Заказы",
        icon = R.drawable.icon_time,
    )

    object Cart: Screen(
        route = "cart",
        title = "Корзина",
        icon = R.drawable.icon_trash,
    )

    object Profile: Screen(
        route = "profile",
        title = "Профиль",
        icon = R.drawable.icon_user,
    )

    companion object {
        const val PIZZA_DETAIL = "pizza_detail"
    }
}