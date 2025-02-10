package dev.k.order_data.models

data class CartPizza(
    val name: String,
    val ingredients: List<CartPizzaIngredient>,
    val toppings: List<CartPizzaIngredient>,
    val description: String,
    val sizes: List<CartPizzaSize>,
    val doughs: List<CartPizzaDough>,
    val calories: Int,
    val protein: String,
    val totalFat: String,
    val carbohydrates: String,
    val sodium: String,
    val allergens: List<String>,
    val isVegetarian: Boolean,
    val isGlutenFree: Boolean,
    val isNew: Boolean,
    val isHit: Boolean,
    val img: String,
    val quantity: Int,
    val cost: Int,
)