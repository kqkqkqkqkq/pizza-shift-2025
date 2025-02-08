package dev.k.ui_kit.components

import dev.k.ui_kit.R

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: Int,
) {
    data object BottomBarPizza : BottomBarScreen(
        route = "pizza",
        title = "Пицца",
        icon = R.drawable.icon_pizza,
    )

    data object BottomBarOrders : BottomBarScreen(
        route = "orders",
        title = "Заказы",
        icon = R.drawable.icon_time,
    )

    data object BottomBarCart : BottomBarScreen(
        route = "cart",
        title = "Корзина",
        icon = R.drawable.icon_trash,
    )

    data object BottomBarProfile : BottomBarScreen(
        route = "profile",
        title = "Профиль",
        icon = R.drawable.icon_user,
    )
}