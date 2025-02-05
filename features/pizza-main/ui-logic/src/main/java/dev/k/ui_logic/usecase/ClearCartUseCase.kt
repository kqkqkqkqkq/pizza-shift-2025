package dev.k.ui_logic.usecase

import dev.k.pizza_data.PizzaRepository
import javax.inject.Inject

internal class ClearCartUseCase @Inject constructor(
    private val repository: PizzaRepository,
) {
    suspend operator fun invoke() {
        repository.clearCart()
    }
}