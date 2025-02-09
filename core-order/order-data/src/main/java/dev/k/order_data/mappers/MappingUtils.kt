package dev.k.order_data.mappers

import dev.k.order_data.models.Topping

internal fun separateToppings(s: String): List<Topping> =
    s.split(separateListPrefix).map {
        val item = it.split(separateListItemPrefix)
        Topping(name = item[0], cost = item[1].toInt())
    }

internal fun joinToppings(l: List<Topping>): String =
    l.joinToString(separateListPrefix) {
        "${it.name}${separateListItemPrefix}${it.cost}"
    }