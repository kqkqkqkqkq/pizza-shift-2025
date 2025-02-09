package dev.k.ui_logic

import dev.k.ui_utils.models.PizzaUI

sealed interface CartScreenState {

    data object Initial : CartScreenState

    data object Loading : CartScreenState

    data class Failure(val message: String?) : CartScreenState

    data class Content(val pizzaList: List<PizzaUI>) : CartScreenState
}