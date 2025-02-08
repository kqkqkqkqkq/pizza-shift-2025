package dev.k.pizza_api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PizzaIngredientDTO(
    @SerialName("name") val name: Ingredient,
    @SerialName("cost") val cost: Int,
    @SerialName("img") val img: String
)