package dev.k.pizza_database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pizzas")
data class PizzaDBO(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo("name") val name: String,
    @ColumnInfo("ingredients") val ingredients: String,
    @ColumnInfo("toppings") val toppings: String,
    @ColumnInfo("description") val description: String,
    @ColumnInfo("sizes") val sizes: String,
    @ColumnInfo("doughs") val doughs: String,
    @ColumnInfo("calories") val calories: Int,
    @ColumnInfo("protein") val protein: String,
    @ColumnInfo("totalFat") val totalFat: String,
    @ColumnInfo("carbohydrates") val carbohydrates: String,
    @ColumnInfo("sodium") val sodium: String,
    @ColumnInfo("allergens") val allergens: String,
    @ColumnInfo("isVegetarian") val isVegetarian: Boolean,
    @ColumnInfo("isGlutenFree") val isGlutenFree: Boolean,
    @ColumnInfo("isNew") val isNew: Boolean,
    @ColumnInfo("isHit") val isHit: Boolean,
    @ColumnInfo("img") val img: String,
)