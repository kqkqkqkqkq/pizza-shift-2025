package dev.k.ui_utils.mappers

import dev.k.order_data.models.CartPizzaDough
import dev.k.order_data.models.CartPizzaIngredient
import dev.k.order_data.models.CartPizzaSize
import dev.k.pizza_data.models.PizzaDough
import dev.k.pizza_data.models.PizzaIngredient
import dev.k.pizza_data.models.PizzaSize
import dev.k.ui_utils.models.PizzaDoughUI
import dev.k.ui_utils.models.PizzaIngredientUI
import dev.k.ui_utils.models.PizzaSizeUI

fun PizzaIngredient.toPizzaIngredientUI(): PizzaIngredientUI =
    PizzaIngredientUI(name = name, cost = cost, img = img, isSelected = false)

fun PizzaSize.toPizzaSizeUI(): PizzaSizeUI =
    PizzaSizeUI(name = name, price = price, isSelected = false)

fun PizzaDough.toPizzaDoughUI(): PizzaDoughUI =
    PizzaDoughUI(name = name, price = price, isSelected = false)

fun PizzaIngredientUI.toPizzaIngredient(): PizzaIngredient =
    PizzaIngredient(name = name, cost = cost, img = img)

fun PizzaSizeUI.toPizzaSize(): PizzaSize =
    PizzaSize(name = name, price = price)

fun PizzaDoughUI.toPizzaDough(): PizzaDough =
    PizzaDough(name = name, price = price)

fun PizzaIngredientUI.toCartPizzaIngredient(): CartPizzaIngredient =
    CartPizzaIngredient(
        name = name,
        cost = cost,
        isSelected = isSelected,
        img = img,
    )

fun CartPizzaIngredient.toPizzaIngredientUI(): PizzaIngredientUI =
    PizzaIngredientUI(
        name = name,
        cost = cost,
        isSelected = isSelected,
        img = img,
    )

fun PizzaSizeUI.toCartPizzaSize(): CartPizzaSize =
    CartPizzaSize(name = name, price = price, isSelected = isSelected)

fun PizzaDoughUI.toCartPizzaDough(): CartPizzaDough =
    CartPizzaDough(name = name, price = price, isSelected = isSelected)

fun CartPizzaSize.toPizzaSizeUI(): PizzaSizeUI =
    PizzaSizeUI(name = name, price = price, isSelected = isSelected)

fun CartPizzaDough.toPizzaDoughUI(): PizzaDoughUI =
    PizzaDoughUI(name = name, price = price, isSelected = isSelected)