package dev.k.domain

import dev.k.domain.models.PizzaUI

sealed interface MainScreenState {

    data object Initial : MainScreenState

    data object Loading: MainScreenState

    data class Failure(val message: String?): MainScreenState

    data class Content(val pizzaList: List<PizzaUI>): MainScreenState
}