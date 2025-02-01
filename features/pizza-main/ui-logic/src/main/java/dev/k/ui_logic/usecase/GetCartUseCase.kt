package dev.k.ui_logic.usecase

import dev.k.ui_logic.mappers.toPizzaUI
import dev.k.ui_logic.models.PizzaUI
import dev.k.pizza_data.PizzaRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class GetCartUseCase @Inject constructor(
    private val repository: PizzaRepository,
) {
    operator fun invoke(): Flow<List<PizzaUI>> =
        repository.getCart().map { it.map { it.toPizzaUI() } }
}