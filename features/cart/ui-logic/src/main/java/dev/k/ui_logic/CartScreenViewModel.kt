package dev.k.ui_logic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.k.ui_utils.models.PizzaUI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@HiltViewModel
class CartScreenViewModel @Inject internal constructor(
    private val getCartUseCase: Provider<GetCartUseCase>,
    private val deleteFromCartUseCase: Provider<DeleteFromCartUseCase>,
) : ViewModel() {

    private val _state = MutableStateFlow<CartScreenState>(CartScreenState.Initial)
    val state: StateFlow<CartScreenState> = _state

    init {
        loadCart()
    }

    private fun loadCart() {
        viewModelScope.launch(Dispatchers.IO) {
            getCartUseCase.get().invoke()
                .map { CartScreenState.Content(it) }
                .collect { _state.value = it }
        }
    }

    fun increaseQuantity(pizza: PizzaUI) {
        pizza.quantity++
    }

    fun decreaseQuantity(pizza: PizzaUI) {
        pizza.quantity--
    }

    fun deleteFromCart(pizza: PizzaUI) {
        viewModelScope.launch(Dispatchers.IO) {
            _state.emit(CartScreenState.Loading)
            deleteFromCartUseCase.get().invoke(pizza)
            loadCart()
        }
    }
}