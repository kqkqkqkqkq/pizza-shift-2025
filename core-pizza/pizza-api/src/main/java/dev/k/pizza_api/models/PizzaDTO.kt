package dev.k.pizza_api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PizzaDTO(
    @SerialName("id") val id: String,
    @SerialName("name") val name: String,
    @SerialName("ingredients") val ingredients: List<PizzaIngredientDTO>,
    @SerialName("toppings") val toppings: List<PizzaIngredientDTO>,
    @SerialName("description") val description: String,
    @SerialName("sizes") val sizes: List<PizzaSizeDTO>,
    @SerialName("doughs") val doughs: List<PizzaDoughDTO>,
    @SerialName("calories") val calories: Int,
    @SerialName("protein") val protein: String,
    @SerialName("totalFat") val totalFat: String,
    @SerialName("carbohydrates") val carbohydrates: String,
    @SerialName("sodium") val sodium: String,
    @SerialName("allergens") val allergens: List<String>,
    @SerialName("isVegetarian") val isVegetarian: Boolean,
    @SerialName("isGlutenFree") val isGlutenFree: Boolean,
    @SerialName("isNew") val isNew: Boolean,
    @SerialName("isHit") val isHit: Boolean,
    @SerialName("img") val img: String,
)