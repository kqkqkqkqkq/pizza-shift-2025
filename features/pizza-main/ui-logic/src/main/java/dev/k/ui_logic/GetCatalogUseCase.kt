package dev.k.ui_logic

import dev.k.pizza_data.PizzaRepository
import dev.k.ui_utils.mappers.toPizzaUI
import dev.k.ui_utils.models.PizzaUI
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class GetCatalogUseCase @Inject constructor(
    private val repository: PizzaRepository,
) {
    operator fun invoke(): Flow<List<PizzaUI>> =
        repository.getCatalog().map { it.map { it.toPizzaUI() } }
}