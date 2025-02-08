package dev.k.ui_logic

import dev.k.pizza_data.PizzaRepository
import dev.k.ui_utils.mappers.toPizza
import dev.k.ui_utils.models.PizzaUI
import javax.inject.Inject

internal class InsertToCartUseCase @Inject constructor(
    private val repository: PizzaRepository,
) {
    suspend operator fun invoke(data: PizzaUI) {
        repository.insertToCars(data.toPizza())
    }
}