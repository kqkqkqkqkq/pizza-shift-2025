package dev.k.ui_utils.mappers

import dev.k.pizza_data.models.Pizza
import dev.k.pizza_data.models.PizzaDough
import dev.k.pizza_data.models.PizzaIngredient
import dev.k.pizza_data.models.PizzaSize
import dev.k.ui_utils.models.PizzaDoughUI
import dev.k.ui_utils.models.PizzaIngredientUI
import dev.k.ui_utils.models.PizzaSizeUI
import dev.k.ui_utils.models.PizzaUI

fun Pizza.toPizzaUI(): PizzaUI =
    PizzaUI(
        id = id,
        name = name,
        ingredients = ingredients
            .map { it.toPizzaIngredientUI() },
        toppings = toppings
            .map { it.toPizzaIngredientUI() },
        description = description,
        sizes = sizes
            .map { it.toPizzaSizeUI() },
        doughs = doughs
            .map { it.toPizzaDoughUI() },
        calories = calories,
        protein = protein,
        totalFat = totalFat,
        carbohydrates = carbohydrates,
        sodium = sodium,
        allergens = allergens,
        isVegetarian = isVegetarian,
        isGlutenFree = isGlutenFree,
        isNew = isNew,
        isHit = isHit,
        img = img,
    )

fun PizzaIngredient.toPizzaIngredientUI(): PizzaIngredientUI =
    PizzaIngredientUI(name = name, cost = cost, img = img)

fun PizzaSize.toPizzaSizeUI(): PizzaSizeUI =
    PizzaSizeUI(name = name, price = price)

fun PizzaDough.toPizzaDoughUI(): PizzaDoughUI =
    PizzaDoughUI(name = name, price = price)

fun PizzaUI.toPizza(): Pizza =
    Pizza(
        id = id,
        name = name,
        ingredients = ingredients
            .map { it.toPizzaIngredient() },
        toppings = toppings
            .map { it.toPizzaIngredient() },
        description = description,
        sizes = sizes
            .map { it.toPizzaSize() },
        doughs = doughs
            .map { it.toPizzaDough() },
        calories = calories,
        protein = protein,
        totalFat = totalFat,
        carbohydrates = carbohydrates,
        sodium = sodium,
        allergens = allergens,
        isVegetarian = isVegetarian,
        isGlutenFree = isGlutenFree,
        isNew = isNew,
        isHit = isHit,
        img = img,
    )

fun PizzaIngredientUI.toPizzaIngredient(): PizzaIngredient =
    PizzaIngredient(name = name, cost = cost, img = img)

fun PizzaSizeUI.toPizzaSize(): PizzaSize =
    PizzaSize(name = name, price = price)

fun PizzaDoughUI.toPizzaDough(): PizzaDough =
    PizzaDough(name = name, price = price)