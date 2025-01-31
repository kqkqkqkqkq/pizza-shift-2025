package dev.k.domain.usecase

import dev.k.domain.mappers.toPizzaUI
import dev.k.domain.models.PizzaUI
import dev.k.pizza_data.PizzaRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class GetCatalogUseCase @Inject constructor(
    private val repository: PizzaRepository,
){
    operator fun invoke(): Flow<List<PizzaUI>> =
        repository.getCatalog().map { it.map { it.toPizzaUI() } }
}