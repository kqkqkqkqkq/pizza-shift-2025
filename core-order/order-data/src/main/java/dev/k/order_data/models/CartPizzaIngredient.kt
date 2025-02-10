package dev.k.order_data.models

data class CartPizzaIngredient(
    val name: String,
    val cost: Int,
    val img: String,
    val isSelected: Boolean,
)