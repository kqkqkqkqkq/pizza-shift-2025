package dev.k.order_database.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart")
data class CartPizzaDBO(
    @PrimaryKey(autoGenerate = true)
    val cartPizzaId: Long = 0,
    val name: String,
    @Embedded val toppings: String?,
    val size: String,
    val dough: String,
    val cost: Int,
    val img: String,
    val quantity: Int,
)