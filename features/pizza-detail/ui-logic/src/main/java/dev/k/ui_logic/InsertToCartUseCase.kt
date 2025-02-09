package dev.k.ui_logic

import dev.k.order_data.OrderRepository
import dev.k.ui_utils.mappers.toCartPizza
import dev.k.ui_utils.models.PizzaUI
import javax.inject.Inject

internal class InsertToCartUseCase @Inject constructor(
    private val repository: OrderRepository,
) {
    suspend operator fun invoke(
        data: PizzaUI,
        sizeIndex: Int,
        doughIndex: Int,
        cost: Int,
        quantity: Int = 1,
    ) {
        repository.insertPizzaToCart(data.toCartPizza(sizeIndex, doughIndex, cost, quantity))
    }
}