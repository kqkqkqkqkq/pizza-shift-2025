package dev.k.ui_logic.screens.pizza_screen

import dev.k.ui_logic.models.PizzaUI

sealed interface PizzaScreenState {

    data object Initial : PizzaScreenState

    data object Loading : PizzaScreenState

    data class Failure(val message: String?) : PizzaScreenState

    data class Content(val pizzaList: List<PizzaUI>) : PizzaScreenState
}