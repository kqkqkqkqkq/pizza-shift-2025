package dev.k.ui_logic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.k.ui_utils.models.PizzaUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@HiltViewModel
class PizzaDetailVewModel @Inject internal constructor(
    private val insertToCartUseCase: Provider<InsertToCartUseCase>,
) : ViewModel() {

    private val _selectedSize = MutableStateFlow(0)
    val selectedSize: StateFlow<Int> = _selectedSize

    private val _selectedAdditions = MutableStateFlow(emptySet<String>())
    val selectedAdditions: StateFlow<Set<String>> = _selectedAdditions

    fun selectSize(position: Int) {
        _selectedSize.value = position
    }

    fun selectAdditions(additions: Set<String>) {
        _selectedAdditions.value = additions
    }

    fun insert(data: PizzaUI) {
        val pizza = data.copy(
            sizes = listOf(data.sizes[_selectedSize.value]),
            toppings = data.toppings.filter { it.name in selectedAdditions.value }
        )
        viewModelScope.launch {
            insertToCartUseCase.get().invoke(pizza)
        }
    }
}