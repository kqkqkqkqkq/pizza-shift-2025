package dev.k.ui_logic.screens.cart_screen

import dev.k.ui_logic.models.PizzaUI

sealed interface CartScreenState {

    data object Initial : CartScreenState

    data object Loading: CartScreenState

    data class Failure(val message: String?): CartScreenState

    data class Content(val cartList: List<PizzaUI>): CartScreenState
}