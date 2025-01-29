package dev.k.pizza_api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PizzaSizeDTO(
    @SerialName("name") val name: Size,
    @SerialName("price") val price: Int,
)