package dev.k.order_data

import android.util.Log
import dev.k.order_data.mappers.toCartPizza
import dev.k.order_data.mappers.toCartPizzaDBO
import dev.k.order_data.mappers.toOrderDBO
import dev.k.order_data.models.CartPizza
import dev.k.order_data.models.CartPizzaDough
import dev.k.order_data.models.CartPizzaIngredient
import dev.k.order_data.models.CartPizzaSize
import dev.k.order_data.models.Order
import dev.k.order_database.OrderDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class OrderRepository @Inject constructor(
    private val database: OrderDatabase,
) {

    fun getCart(): Flow<List<CartPizza>> = flow {
        emit(database.orderDao.getCart().map { it.toCartPizza() })
    }.flowOn(Dispatchers.IO)

    suspend fun insertPizzaToCart(pizza: CartPizza) {
        val pizzaInCart = checkInCart(pizza).firstOrNull()
        if (pizzaInCart == null) database.orderDao.insertCartPizza(pizza.toCartPizzaDBO())
        else database.orderDao.updatePizzaInCartQuantity(pizzaInCart.first)
    }

    suspend fun deletePizzaFromCart(pizza: CartPizza) {
        val pizzaToDelete = checkInCart(pizza).first()
        database.orderDao.removePizzaFromCart(pizzaToDelete.first)
    }

    suspend fun makeOrder(order: Order, pizzaList: List<CartPizza>) {
        database.orderDao.placeOrder(order.toOrderDBO(), pizzaList.map { it.toCartPizzaDBO() })
    }

    private suspend fun checkInCart(pizza: CartPizza): List<Pair<Long, CartPizza>> {
        val cart = database.orderDao.getCart().map { it.cartPizzaId to it.toCartPizza() }
        val identity = mutableListOf<Pair<Long, CartPizza>>()
        cart.forEach {
                if (it.second.name == pizza.name && checkSize(it.second.sizes, pizza.sizes)
                    && checkDough(it.second.doughs, pizza.doughs) && checkTopping(it.second.toppings, pizza.toppings))
                        identity.add(it)
            }
        Log.e("Repository", identity.toString())
        return identity
    }

    private fun checkSize(cartSizes: List<CartPizzaSize>, sizes: List<CartPizzaSize>): Boolean {
        for (i in cartSizes.indices)
            if (cartSizes[i].isSelected != sizes[i].isSelected)
                return false
        return true
    }

    private fun checkDough(cartDoughs: List<CartPizzaDough>, doughs: List<CartPizzaDough>): Boolean {
        for (i in cartDoughs.indices)
            if (cartDoughs[i].isSelected != doughs[i].isSelected)
                return false
        return true
    }

    private fun checkTopping(cartToppings: List<CartPizzaIngredient>, toppings: List<CartPizzaIngredient>): Boolean {
        for (i in cartToppings.indices)
            if (cartToppings[i].isSelected != toppings[i].isSelected)
                return false
        return true
    }
}