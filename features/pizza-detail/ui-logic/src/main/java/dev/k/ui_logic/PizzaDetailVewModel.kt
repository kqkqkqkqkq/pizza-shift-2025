package dev.k.ui_logic

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.k.ui_utils.models.PizzaIngredientUI
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

    fun selectSize(position: Int) {
        _selectedSize.value = position
    }

    fun selectDough(position: Int) {
        _selectedDough.value = position
    }

    fun selectAdditions(addition: PizzaIngredientUI) {
        addition.isSelected = !addition.isSelected
    }

    private fun calculateCost(data: PizzaUI): Int =
        data.sizes[_selectedSize.value].price +
                data.doughs[_selectedDough.value].price +
                data.toppings.filter { it.isSelected }.sumOf { it.cost }


    fun insert(data: PizzaUI) {
        val pizzaCost = calculateCost(data)
        data.doughs[_selectedDough.value].isSelected = true
        data.sizes[_selectedSize.value].isSelected = true
        data.quantity = 1
        viewModelScope.launch {
            insertToCartUseCase.get().invoke(
                data = data,
                cost = pizzaCost,
            )
        }
        Log.e("Inserted pizza", data.toString())
    }
}