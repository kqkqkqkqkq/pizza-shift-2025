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

    private val _selectedDough = MutableStateFlow(0)
    val selectedDough: StateFlow<Int> = _selectedDough

    private val _selectedAdditions = MutableStateFlow(emptyList<String>())
    val selectedAdditions: StateFlow<List<String>> = _selectedAdditions

    fun selectSize(position: Int) {
        _selectedSize.value = position
    }

    fun selectDough(position: Int) {
        _selectedDough.value = position
    }

    fun selectAdditions(additions: List<String>) {
        _selectedAdditions.value = additions
    }

    private fun calculateCost(data: PizzaUI): Int =
        data.sizes[_selectedSize.value].price +
                data.doughs[_selectedDough.value].price +
                data.toppings.sumOf { it.cost }


    fun insert(data: PizzaUI) {
        val pizza = data.copy(
            toppings = data.toppings.filter { it.name in selectedAdditions.value }
        )
        val pizzaCost = calculateCost(pizza)
        viewModelScope.launch {
            insertToCartUseCase.get().invoke(
                data = pizza,
                sizeIndex = _selectedSize.value,
                doughIndex = _selectedDough.value,
                cost = pizzaCost,
            )
        }
    }
}