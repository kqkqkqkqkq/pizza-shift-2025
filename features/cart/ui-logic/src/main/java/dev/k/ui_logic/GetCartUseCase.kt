package dev.k.ui_logic

import dev.k.order_data.OrderRepository
import dev.k.ui_utils.mappers.toPizzaUI
import dev.k.ui_utils.models.PizzaUI
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class GetCartUseCase @Inject constructor(
    private val repository: OrderRepository,
) {
    operator fun invoke(): Flow<List<PizzaUI>> =
        repository.getCart().map { it.map { it.toPizzaUI() } }
}