package dev.k.ui_logic.usecase

import dev.k.pizza_data.PizzaRepository
import dev.k.ui_logic.mappers.toPizza
import dev.k.ui_logic.models.PizzaUI
import javax.inject.Inject

internal class DeleteFromCartUseCase @Inject constructor(
    private val repository: PizzaRepository,
) {
    suspend operator fun invoke(data: PizzaUI) {
        repository.removeFromCart(data.toPizza())
    }
}