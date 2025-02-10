package dev.k.order_database.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart")
data class CartPizzaDBO(
    @PrimaryKey(autoGenerate = true)
    val cartPizzaId: Long = 0,
    val name: String,
    val ingredients: String,
    val toppings: String,
    val description: String,
    val sizes: String,
    val doughs: String,
    val calories: Int,
    val protein: String,
    val totalFat: String,
    val carbohydrates: String,
    val sodium: String,
    val allergens: String,
    val isVegetarian: Boolean,
    val isGlutenFree: Boolean,
    val isNew: Boolean,
    val isHit: Boolean,
    val img: String,
    val quantity: Int,
    val cost: Int,
)