package dev.k.ui_utils.mappers

import dev.k.pizza_data.models.Pizza
import dev.k.ui_utils.models.PizzaUI

fun Pizza.toPizzaUI(): PizzaUI =
    PizzaUI(
        id = id,
        name = name,
        ingredients = ingredients.map { it.toPizzaIngredientUI() },
        toppings = toppings.map { it.toPizzaIngredientUI() },
        description = description,
        sizes = sizes.map { it.toPizzaSizeUI() },
        doughs = doughs.map { it.toPizzaDoughUI() },
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

fun PizzaUI.toPizza(): Pizza =
    Pizza(
        id = id,
        name = name,
        ingredients = ingredients.map { it.toPizzaIngredient() },
        toppings = toppings.map { it.toPizzaIngredient() },
        description = description,
        sizes = sizes.map { it.toPizzaSize() },
        doughs = doughs.map { it.toPizzaDough() },
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