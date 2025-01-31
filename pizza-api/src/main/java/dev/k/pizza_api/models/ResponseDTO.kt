package dev.k.pizza_api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseDTO<T>(
    @SerialName("success") val success: Boolean,
    @SerialName("reason") val reason: String? = null,
    @SerialName("catalog") val catalog: List<T>,
)