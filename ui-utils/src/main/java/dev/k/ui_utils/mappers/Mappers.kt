package dev.k.ui_utils.mappers

import dev.k.order_data.models.CartPizza
import dev.k.pizza_data.models.Pizza
import dev.k.ui_utils.models.PizzaDoughUI
import dev.k.ui_utils.models.PizzaSizeUI
import dev.k.ui_utils.models.PizzaUI

fun Pizza.toPizzaUI(): PizzaUI =
    PizzaUI(
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

fun PizzaUI.toCartPizza(sizeIndex: Int, doughIndex: Int, cost: Int, quantity: Int): CartPizza =
    CartPizza(
        name = name,
        toppings = toppings.map { it.toTopping() },
        size = sizes[sizeIndex].name,
        dough = doughs[doughIndex].name,
        cost = cost,
        img = img,
        quantity = quantity,
    )

fun CartPizza.toPizzaUI() = PizzaUI(
    name = name,
    toppings = toppings?.map { it.toPizzaIngredientUI() } ?: emptyList(),
    sizes = listOf(PizzaSizeUI(name, 0)),
    doughs = listOf(PizzaDoughUI(name, 0)),
    img = img,
    ingredients = emptyList(),
    description = "",
    calories = 0,
    protein = "",
    totalFat = "",
    carbohydrates = "",
    sodium = "",
    allergens = emptyList(),
    isVegetarian = false,
    isGlutenFree = false,
    isNew = false,
    isHit = false,
)