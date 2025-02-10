package dev.k.order_data.mappers

import dev.k.order_data.models.CartPizzaDough
import dev.k.order_data.models.CartPizzaIngredient
import dev.k.order_data.models.CartPizzaSize

internal fun separateCartPizzaIngredients(s: String): List<CartPizzaIngredient> =
    s.split(separateListPrefix).map {
        val item = it.split(separateListItemPrefix)
        CartPizzaIngredient(
            name = item[0],
            cost = item[1].toInt(),
            isSelected = item[2].toBoolean(),
            img = item[3],
        )
    }

internal fun separateSizes(s: String): List<CartPizzaSize> =
    s.split(separateListPrefix).map {
        val item = it.split(separateListItemPrefix)
        CartPizzaSize(name = item[0], price = item[1].toInt(), isSelected = item[2].toBoolean())
    }

internal fun separateDoughs(s: String): List<CartPizzaDough> =
    s.split(separateListPrefix).map {
        val item = it.split(separateListItemPrefix)
        CartPizzaDough(name = item[0], price = item[1].toInt(), isSelected = item[2].toBoolean())
    }

internal fun joinCartPizzaIngredients(l: List<CartPizzaIngredient>): String =
    l.joinToString(separateListPrefix) {
        "${it.name}${separateListItemPrefix}${it.cost}${separateListItemPrefix}${it.isSelected}${separateListItemPrefix}${it.img}"
    }

internal fun joinSizes(l: List<CartPizzaSize>): String =
    l.joinToString(separateListPrefix) {
        "${it.name}${separateListItemPrefix}${it.price}${separateListItemPrefix}${it.isSelected}"
    }

internal fun joinDoughs(l: List<CartPizzaDough>): String =
    l.joinToString(separateListPrefix) {
        "${it.name}${separateListItemPrefix}${it.price}${separateListItemPrefix}${it.isSelected}"
    }