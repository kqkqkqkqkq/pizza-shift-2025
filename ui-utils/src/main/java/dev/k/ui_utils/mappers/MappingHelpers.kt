package dev.k.ui_utils.mappers

import dev.k.pizza_data.models.PizzaDough
import dev.k.pizza_data.models.PizzaIngredient
import dev.k.pizza_data.models.PizzaSize
import dev.k.ui_utils.models.PizzaDoughUI
import dev.k.ui_utils.models.PizzaIngredientUI
import dev.k.ui_utils.models.PizzaSizeUI

fun PizzaIngredient.toPizzaIngredientUI(): PizzaIngredientUI =
    PizzaIngredientUI(name = name, cost = cost, img = img)

fun PizzaSize.toPizzaSizeUI(): PizzaSizeUI =
    PizzaSizeUI(name = name, price = price)

fun PizzaDough.toPizzaDoughUI(): PizzaDoughUI =
    PizzaDoughUI(name = name, price = price)

fun PizzaIngredientUI.toPizzaIngredient(): PizzaIngredient =
    PizzaIngredient(name = name, cost = cost, img = img)

fun PizzaSizeUI.toPizzaSize(): PizzaSize =
    PizzaSize(name = name, price = price)

fun PizzaDoughUI.toPizzaDough(): PizzaDough =
    PizzaDough(name = name, price = price)