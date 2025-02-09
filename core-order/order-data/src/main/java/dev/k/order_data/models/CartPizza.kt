package dev.k.order_data.models

data class CartPizza(
    val name: String,
    val toppings: List<Topping>?,
    val size: String,
    val dough: String,
    val cost: Int,
    val img: String,
    val quantity: Int,
)