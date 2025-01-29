package dev.k.pizza_api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PizzaDoughDTO(
    @SerialName("name") val name: Dough,
    @SerialName("price") val price: Int,
)
