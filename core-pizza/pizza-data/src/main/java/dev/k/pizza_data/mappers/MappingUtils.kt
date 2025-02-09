package dev.k.pizza_data.mappers

import dev.k.pizza_data.models.PizzaDough
import dev.k.pizza_data.models.PizzaIngredient
import dev.k.pizza_data.models.PizzaSize

internal fun separateIngredients(s: String): List<PizzaIngredient> {
    if (s.isEmpty()) return emptyList()
    return s.split(separateListPrefix).map {
        val item = it.split(separateListItemPrefix)
        PizzaIngredient(name = item[0], cost = item[1].toInt(), img = item[2])
    }
}

internal fun separateSizes(s: String): List<PizzaSize> =
    s.split(separateListPrefix).map {
        val item = it.split(separateListItemPrefix)
        PizzaSize(name = item[0], price = item[1].toInt())
    }

internal fun separateDoughs(s: String): List<PizzaDough> =
    s.split(separateListPrefix).map {
        val item = it.split(separateListItemPrefix)
        PizzaDough(name = item[0], price = item[1].toInt())
    }

internal fun joinIngredients(l: List<PizzaIngredient>): String =
    l.joinToString(separateListPrefix) {
        "${it.name}${separateListItemPrefix}${it.cost}${separateListItemPrefix}${it.img}"
    }

internal fun joinSizes(l: List<PizzaSize>): String =
    l.joinToString(separateListPrefix) {
        "${it.name}${separateListItemPrefix}${it.price}"
    }

internal fun joinDoughs(l: List<PizzaDough>): String =
    l.joinToString(separateListPrefix) {
        "${it.name}${separateListItemPrefix}${it.price}"
    }