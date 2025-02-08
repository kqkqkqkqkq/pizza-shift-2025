package dev.k.pizza_data.mappers

import dev.k.pizza_api.models.PizzaDTO
import dev.k.pizza_data.models.Pizza
import dev.k.pizza_database.models.PizzaDBO

internal fun PizzaDBO.toPizza(): Pizza {
    return Pizza(
        id = id.toString(),
        name = name,
        ingredients = separateIngredients(ingredients),
        toppings = separateIngredients(toppings),
        description = description,
        sizes = separateSizes(sizes),
        doughs = separateDoughs(doughs),
        calories = calories,
        protein = protein,
        totalFat = totalFat,
        carbohydrates = carbohydrates,
        sodium = sodium,
        allergens = allergens.split(separateListPrefix),
        isVegetarian = isVegetarian,
        isGlutenFree = isGlutenFree,
        isNew = isNew,
        isHit = isHit,
        img = img,
    )
}

internal fun Pizza.toPizzaDBO(): PizzaDBO =
    PizzaDBO(
        name = name,
        ingredients = joinIngredients(ingredients),
        toppings = joinIngredients(toppings),
        description = description,
        sizes = joinSizes(sizes),
        doughs = joinDoughs(doughs),
        calories = calories,
        protein = protein,
        totalFat = totalFat,
        carbohydrates = carbohydrates,
        sodium = sodium,
        allergens = allergens.joinToString(separateListPrefix),
        isVegetarian = isVegetarian,
        isGlutenFree = isGlutenFree,
        isNew = isNew,
        isHit = isHit,
        img = img,
    )

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
        img = imagePrefix + img,
    )