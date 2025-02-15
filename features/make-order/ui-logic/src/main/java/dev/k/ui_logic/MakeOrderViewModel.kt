package dev.k.ui_logic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.k.order_data.OrderRepository
import dev.k.order_data.models.Order
import dev.k.order_data.models.OrderStatus
import dev.k.ui_utils.mappers.toCustomer
import dev.k.ui_utils.models.CustomerUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class MakeOrderViewModel @Inject constructor(
    private val repository: OrderRepository,
) : ViewModel() {

    private val _customer = MutableStateFlow(CustomerUI())
    val customer: StateFlow<CustomerUI> = _customer

    fun inputName(name: String) {
        _customer.update { it.copy(name = name) }
    }

    fun inputLastName(lastName: String) {
        _customer.update { it.copy(lastName = lastName) }
    }

    fun inputPhoneNumber(phoneNumber: String) {
        _customer.update { it.copy(phoneNumber = phoneNumber) }
    }

    fun inputEmail(email: String) {
        _customer.update { it.copy(email = email) }
    }

    fun inputCountry(country: String) {
        _customer.update { it.copy(country = country) }
    }

    fun inputCity(city: String) {
        _customer.update { it.copy(city = city) }
    }

    fun inputStreet(street: String) {
        _customer.update { it.copy(street = street) }
    }

    fun inputHouse(house: String) {
        _customer.update { it.copy(house = house) }
    }

    fun makeOrder() {
        viewModelScope.launch {
            val pizzaList = repository.getCart().first()
            val price = pizzaList.sumOf { it.cost }
            val order = Order(
                time = Date(),
                status = OrderStatus.ACTIVE,
                customer = customer.value.toCustomer(),
                price = price,
                pizzaList = pizzaList,
            )
            repository.makeOrder(order, pizzaList)
        }
    }
}