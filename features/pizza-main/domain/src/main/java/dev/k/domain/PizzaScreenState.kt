package dev.k.domain

import dev.k.domain.models.PizzaUI

sealed interface PizzaScreenState {

    data object Initial : PizzaScreenState

    data object Loading: PizzaScreenState

    data class Failure(val message: String?): PizzaScreenState

    data class Content(val pizzaList: List<PizzaUI>): PizzaScreenState
}