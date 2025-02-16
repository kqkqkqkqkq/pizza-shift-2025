package dev.k.ui_logic

import dev.k.ui_utils.models.PizzaUI

sealed interface PizzaScreenState {

    data object Initial : PizzaScreenState

    data object Loading : PizzaScreenState

    data class Failure(val message: String?) : PizzaScreenState

    data class Content(val pizzaList: List<PizzaUI>) : PizzaScreenState
}