package dev.k.pizza_data.mappers

import dev.k.pizza_api.models.PizzaDTO
import dev.k.pizza_api.models.PizzaDoughDTO
import dev.k.pizza_api.models.PizzaIngredientDTO
import dev.k.pizza_api.models.PizzaSizeDTO
import dev.k.pizza_data.models.Pizza
import dev.k.pizza_data.models.PizzaDough
import dev.k.pizza_data.models.PizzaIngredient
import dev.k.pizza_data.models.PizzaSize

internal fun PizzaDTO.toPizza(): Pizza =
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


internal fun PizzaIngredientDTO.toPizzaIngredient(): PizzaIngredient =
    PizzaIngredient(name = name.toString(), cost = cost, img = img)

internal fun PizzaSizeDTO.toPizzaSize(): PizzaSize =
    PizzaSize(name = name.toString(), price = price)

internal fun PizzaDoughDTO.toPizzaDough(): PizzaDough =
    PizzaDough(name = name.toString(), price = price)