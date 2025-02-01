package dev.k.ui_logic.screens.cart_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.k.ui_logic.models.PizzaUI
import dev.k.ui_logic.usecase.DeleteFromCartUseCase
import dev.k.ui_logic.usecase.GetCartUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@HiltViewModel
class CartScreenViewModel @Inject internal constructor(
    private val getCartUseCase: Provider<GetCartUseCase>,
    private val deleteFromCartUseCase: Provider<DeleteFromCartUseCase>,
): ViewModel() {

//    private val _quantity = MutableStateFlow(emptyMap<PizzaUI, Int>())
//    val quantity: StateFlow<Map<PizzaUI, Int>> = _quantity

    private val _quantity = MutableStateFlow(1)
    val quantity: StateFlow<Int> = _quantity

    private var _state = MutableStateFlow<Set<PizzaUI>>(emptySet())
    val state: StateFlow<Set<PizzaUI>> = _state

    fun updateState() {
        viewModelScope.launch {
            getCartUseCase.get().invoke().collect {
                _state.value = it.toSet()
            }
        }
//        _state.value.map {
//            _quantity.value = _quantity.value.toMutableMap().apply {
//                this[it] = 1
//            }
//        }
    }
    init {
        updateState()
    }

    fun deleteFromCart(data: PizzaUI) {
        viewModelScope.launch {
            deleteFromCartUseCase.get().invoke(data)
            updateState()
        }
    }

//    fun quantityChange(pizza: PizzaUI, amount: Int) {
//        _quantity.value = _quantity.value.toMutableMap().apply {
//            this[pizza] = amount
//        }
//    }
    fun quantityChange(amount: Int) {
        _quantity.value = amount
    }
}