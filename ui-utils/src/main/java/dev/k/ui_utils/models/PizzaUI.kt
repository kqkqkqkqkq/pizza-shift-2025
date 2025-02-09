package dev.k.ui_utils.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PizzaUI(
    val name: String,
    val ingredients: List<PizzaIngredientUI>,
    val toppings: List<PizzaIngredientUI>,
    val description: String,
    val sizes: List<PizzaSizeUI>,
    val doughs: List<PizzaDoughUI>,
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
) : Parcelable