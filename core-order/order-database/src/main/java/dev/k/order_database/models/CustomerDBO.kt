package dev.k.order_database.models

data class CustomerDBO(
    val name: String,
    val lastName: String,
    val phoneNumber: String,
    val email: String,
    val country: String,
    val city: String,
    val street: String,
    val house: String,
)