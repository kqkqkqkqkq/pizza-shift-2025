package dev.k.order_data.mappers

import dev.k.order_data.models.Customer
import dev.k.order_data.models.OrderStatus
import dev.k.order_database.models.CustomerDBO

internal fun toOrderStatus(s: String): OrderStatus {
    return when(s) {
        "CANCELED" -> OrderStatus.CANCELED
        "COMPLETED" -> OrderStatus.COMPLETED
        "ACTIVE" -> OrderStatus.ACTIVE
        else -> throw IllegalArgumentException("Unknown order status: $s")
    }
}

internal fun CustomerDBO.toCustomer(): Customer {
    return Customer(
        name = name,
        lastName = lastName,
        phoneNumber = phoneNumber,
        email = email,
        country = country,
        city = city,
        street = street,
        house = house,
    )
}

internal fun Customer.toCustomerDBO(): CustomerDBO {
    return CustomerDBO(
        name = name,
        lastName = lastName,
        phoneNumber = phoneNumber,
        email = email,
        country = country,
        city = city,
        street = street,
        house = house,
    )
}