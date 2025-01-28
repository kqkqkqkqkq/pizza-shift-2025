package dev.k.pizza_api.models

import kotlinx.serialization.SerialName

enum class Size {
    @SerialName("SMALL") SMALL,
    @SerialName("MEDIUM") MEDIUM,
    @SerialName("LARGE") LARGE,
}