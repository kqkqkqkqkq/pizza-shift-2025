package dev.k.ui_logic

import dev.k.order_data.OrderRepository
import dev.k.ui_utils.mappers.toCartPizza
import dev.k.ui_utils.models.PizzaUI
import javax.inject.Inject

class DeleteFromCartUseCase @Inject constructor(
    private val repository: OrderRepository,
) {
    suspend operator fun invoke(pizza: PizzaUI) {
        repository.deletePizzaFromCart(pizza.toCartPizza(cost = pizza.cost, quantity = pizza.quantity))
    }
}