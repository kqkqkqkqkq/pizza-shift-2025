package dev.k.pizza_database.models

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pizzas")
data class PizzaDBO(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo("name") val name: String,
    @Embedded(prefix = "ingredients") val ingredients: List<PizzaIngredientDBO>,
    @Embedded(prefix = "toppings") val toppings: List<PizzaIngredientDBO>,
    @ColumnInfo("description") val description: String,
    @Embedded(prefix = "sizes") val sizes: List<PizzaSizeDBO>,
    @Embedded(prefix = "doughs") val doughs: List<PizzaDoughDBO>,
    @ColumnInfo("calories") val calories: Int,
    @ColumnInfo("protein") val protein: String,
    @ColumnInfo("totalFat") val totalFat: String,
    @ColumnInfo("carbohydrates") val carbohydrates: String,
    @ColumnInfo("sodium") val sodium: String,
    @ColumnInfo("allergens") val allergens: List<String>,
    @ColumnInfo("isVegetarian") val isVegetarian: Boolean,
    @ColumnInfo("isGlutenFree") val isGlutenFree: Boolean,
    @ColumnInfo("isNew") val isNew: Boolean,
    @ColumnInfo("isHit") val isHit: Boolean,
    @ColumnInfo("img") val img: String,
)

data class PizzaIngredientDBO(
    val name: String,
    val cost: Int,
    val img: String,
)

data class PizzaSizeDBO(
    val name: String,
    val price: Int,
)

data class PizzaDoughDBO(
    val name: String,
    val price: Int,
)