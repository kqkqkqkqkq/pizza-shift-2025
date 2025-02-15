package dev.k.order_data.models

data class Customer(
    val name: String,
    val lastName: String,
    val phoneNumber: String,
    val email: String,
    val country: String,
    val city: String,
    val street: String,
    val house: String,
)
