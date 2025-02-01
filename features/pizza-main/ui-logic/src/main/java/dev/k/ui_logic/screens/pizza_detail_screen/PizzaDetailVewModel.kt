package dev.k.ui_logic.screens.pizza_detail_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.k.ui_logic.models.PizzaSizeUI
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
    private val _selectedSize = MutableStateFlow(0)
    val selectedSize: StateFlow<Int> = _selectedSize

    fun selectSize(position: Int) {
        _selectedSize.value = position
    }

    private val _selectedAdditions = MutableStateFlow(emptySet<String>())
    val selectedAdditions: StateFlow<Set<String>> = _selectedAdditions

    fun selectAdditions(additions: Set<String>) {
        _selectedAdditions.value = additions
    }

    fun insert(data: PizzaUI) {
        val pizza = data.copy(
            sizes = listOf(data.sizes.get(_selectedSize.value)),
            toppings = data.toppings.filter { it.name in selectedAdditions.value }
        )
        Log.e("insert pizza", pizza.toString())
        viewModelScope.launch {
            insertToCartUseCase.get().invoke(pizza)
        }
    }

}

//PizzaUI(
//id=3,
//name=Четыре Сыра,
//ingredients=[
//PizzaIngredientUI(name=Моцарелла, cost=70, img=https://shift-intensive.ru/api/static/images/ingredient/mozzarella.png),
//PizzaIngredientUI(name=Чедр, cost=90, img=https://shift-intensive.ru/api/static/images/ingredient/cheddar.png),
//PizzaIngredientUI(name=Пармезан, cost=90, img=https://shift-intensive.ru/api/static/images/ingredient/green_pepper.png)],
//toppings=[],
//description=Пицца с миксом моцареллы, чеддера, пармезана и феты.,
//sizes=[PizzaSizeUI(name=Средняя, price=849)],
//doughs=[PizzaDoughUI(name=Тонкое, price=0),
//PizzaDoughUI(name=Толстое, price=50)],
//calories=380,
//protein=20г,
//totalFat=18г,
//carbohydrates=30г,
//sodium=780мг,
//allergens=[молоко, пшеница],
//isVegetarian=true,
//isGlutenFree=false,
//isNew=true,
//isHit=false,
//img=https://shift-intensive.ru/api/static/images/pizza/3.webp)
