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

internal fun CartPizzaDBO.toCartPizza(): CartPizza {
    return CartPizza(
        name = name,
        toppings = toppings?.let { separateToppings(it) },
        size = size,
        dough = dough,
        cost = cost,
        img = img,
        quantity = quantity,
    )
}

internal fun Order.toOrderDBO(): OrderDBO {
    return OrderDBO(
        time = time,
        status = status.toString(),
        price = price,
        customer = customer.toCustomerDBO(),
    )
}

internal fun CartPizza.toCartPizzaDBO(): CartPizzaDBO {
    return CartPizzaDBO(
        name = name,
        toppings = toppings?.let { joinToppings(it) },
        size = size,
        dough = dough,
        cost = cost,
        img = img,
        quantity = quantity,
    )
}