package dev.k.order_data.models

import java.util.Date

data class Order(
    val time: Date,
    val status: OrderStatus,
    val customer: Customer,
    val price: Int,
    val pizzaList: List<CartPizza>,
)