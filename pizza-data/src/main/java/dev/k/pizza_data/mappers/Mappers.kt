package dev.k.pizza_data.mappers

import dev.k.pizza_api.models.Dough
import dev.k.pizza_api.models.Ingredient
import dev.k.pizza_api.models.PizzaDTO
import dev.k.pizza_api.models.PizzaDoughDTO
import dev.k.pizza_api.models.PizzaIngredientDTO
import dev.k.pizza_api.models.PizzaSizeDTO
import dev.k.pizza_api.models.Size
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
    PizzaIngredient(name = ingredientMap[name].toString(), cost = cost, img = img)

internal fun PizzaSizeDTO.toPizzaSize(): PizzaSize =
    PizzaSize(name = sizeMap[name].toString(), price = price)

internal fun PizzaDoughDTO.toPizzaDough(): PizzaDough =
    PizzaDough(name = doughMap[name].toString(), price = price)

private val ingredientMap = mapOf(
    Ingredient.PINEAPPLE to "Ананас",
    Ingredient.MOZZARELLA to "Моцарелла",
    Ingredient.PEPERONI to "Пеперони",
    Ingredient.GREEN_PEPPER to "Зеленый перец",
    Ingredient.MUSHROOMS to "Грибы",
    Ingredient.BASIL to "Базелик",
    Ingredient.CHEDDAR to "Чедр",
    Ingredient.PARMESAN to "Пармезан",
    Ingredient.FETA to "Фета",
    Ingredient.HAM to "Ветчина",
    Ingredient.PICKLE to "Соленый огурец",
    Ingredient.TOMATO to "Помидор",
    Ingredient.BACON to "Бекон",
    Ingredient.ONION to "Лук",
    Ingredient.CHILE to "Чили",
    Ingredient.SHRIMPS to "Креветки",
    Ingredient.CHICKEN_FILLET to "Куринное филе",
    Ingredient.MEATBALLS to "Мясные шарики",
)

private val sizeMap = mapOf(
    Size.LARGE to "Большая",
    Size.MEDIUM to "Средняя",
    Size.SMALL to "Маленькая",
)

private val doughMap = mapOf(
    Dough.THIN to "Тонкое",
    Dough.THICK to "Толстое",
)