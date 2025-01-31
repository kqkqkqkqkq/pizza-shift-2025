package dev.k.domain.mappers

import dev.k.domain.models.PizzaDoughUI
import dev.k.domain.models.PizzaIngredientUI
import dev.k.domain.models.PizzaSizeUI
import dev.k.domain.models.PizzaUI
import dev.k.pizza_data.models.Pizza
import dev.k.pizza_data.models.PizzaDough
import dev.k.pizza_data.models.PizzaIngredient
import dev.k.pizza_data.models.PizzaSize

internal fun Pizza.toPizza(): PizzaUI =
    PizzaUI(
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

internal fun PizzaIngredient.toPizzaIngredient(): PizzaIngredientUI =
    PizzaIngredientUI(name = name, cost = cost, img = img)

internal fun PizzaSize.toPizzaSize(): PizzaSizeUI =
    PizzaSizeUI(name = name, price = price)

internal fun PizzaDough.toPizzaDough(): PizzaDoughUI =
    PizzaDoughUI(name = name, price = price)