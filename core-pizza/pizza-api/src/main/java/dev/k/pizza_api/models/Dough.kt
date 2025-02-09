package dev.k.pizza_api.models

import kotlinx.serialization.SerialName

enum class Dough {
    @SerialName("THIN")
    THIN,

    @SerialName("THICK")
    THICK,
}