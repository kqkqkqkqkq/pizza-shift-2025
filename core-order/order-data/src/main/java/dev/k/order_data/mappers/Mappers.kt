package dev.k.order_data.mappers

import dev.k.order_data.models.CartPizza
import dev.k.order_data.models.Order
import dev.k.order_database.models.CartPizzaDBO
import dev.k.order_database.models.OrderDBO
import dev.k.order_database.models.OrderWithPizza

internal fun OrderWithPizza.toOrder(): Order {
    return Order(
        time = order.time,
        status = toOrderStatus(order.status),
        customer = order.customer.toCustomer(),
        price = order.price,
        pizzaList = pizzaList.map { it.toCartPizza() },
    )
}

internal fun CartPizzaDBO.toCartPizza(): CartPizza =
    CartPizza(
        name = name,
        ingredients = separateCartPizzaIngredients(ingredients),
        toppings = separateCartPizzaIngredients(toppings),
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
        quantity = quantity,
        cost = cost,
    )

internal fun Order.toOrderDBO(): OrderDBO {
    return OrderDBO(
        time = time,
        status = status.toString(),
        price = price,
        customer = customer.toCustomerDBO(),
    )
}

internal fun CartPizza.toCartPizzaDBO(): CartPizzaDBO =
    CartPizzaDBO(
        name = name,
        ingredients = joinCartPizzaIngredients(ingredients),
        toppings = joinCartPizzaIngredients(toppings),
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
        quantity = quantity,
        cost = cost,
    )