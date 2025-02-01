package dev.k.ui_logic.screens.pizza_detail_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.k.ui_logic.models.PizzaUI
import dev.k.ui_logic.usecase.InsertToCartUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@HiltViewModel
class PizzaDetailVewModel @Inject internal constructor (
    private val insertToCartUseCase: Provider<InsertToCartUseCase>,
): ViewModel() {

    fun insert(data: PizzaUI) {
        viewModelScope.launch {
            insertToCartUseCase.get().invoke(data)
        }
    }

    private val _selectedSize = MutableStateFlow(0)
    val selectedSize: StateFlow<Int> = _selectedSize

    fun selectSize(position: Int) {
        _selectedSize.value = position
    }
}