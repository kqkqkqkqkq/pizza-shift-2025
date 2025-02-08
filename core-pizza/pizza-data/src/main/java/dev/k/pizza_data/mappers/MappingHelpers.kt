package dev.k.pizza_data.mappers

import dev.k.pizza_api.models.PizzaDoughDTO
import dev.k.pizza_api.models.PizzaIngredientDTO
import dev.k.pizza_api.models.PizzaSizeDTO
import dev.k.pizza_data.models.PizzaDough
import dev.k.pizza_data.models.PizzaIngredient
import dev.k.pizza_data.models.PizzaSize

internal fun PizzaIngredientDTO.toPizzaIngredient(): PizzaIngredient =
    PizzaIngredient(name = name.toString(), cost = cost, img = imagePrefix + img)

internal fun PizzaSizeDTO.toPizzaSize(): PizzaSize =
    PizzaSize(name = name.toString(), price = price)

internal fun PizzaDoughDTO.toPizzaDough(): PizzaDough =
    PizzaDough(name = name.toString(), price = price)