package dev.k.pizza_api.models

import kotlinx.serialization.SerialName

enum class Ingredient {
    @SerialName("PINEAPPLE")
    PINEAPPLE,

    @SerialName("MOZZARELLA")
    MOZZARELLA,

    @SerialName("PEPERONI")
    PEPERONI,

    @SerialName("GREEN_PEPPER")
    GREEN_PEPPER,

    @SerialName("MUSHROOMS")
    MUSHROOMS,

    @SerialName("BASIL")
    BASIL,

    @SerialName("CHEDDAR")
    CHEDDAR,

    @SerialName("PARMESAN")
    PARMESAN,

    @SerialName("FETA")
    FETA,

    @SerialName("HAM")
    HAM,

    @SerialName("PICKLE")
    PICKLE,

    @SerialName("TOMATO")
    TOMATO,

    @SerialName("BACON")
    BACON,

    @SerialName("ONION")
    ONION,

    @SerialName("CHILE")
    CHILE,

    @SerialName("SHRIMPS")
    SHRIMPS,

    @SerialName("CHICKEN_FILLET")
    CHICKEN_FILLET,

    @SerialName("MEATBALLS")
    MEATBALLS,
}