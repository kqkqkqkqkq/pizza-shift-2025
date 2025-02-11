package dev.k.order_data

import dev.k.order_data.mappers.toCartPizza
import dev.k.order_data.mappers.toCartPizzaDBO
import dev.k.order_data.mappers.toOrderDBO
import dev.k.order_data.models.CartPizza
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
        database.orderDao.insertCartPizza(pizza.toCartPizzaDBO())
    }

    suspend fun deletePizzaFromCart(pizza: CartPizza) {
        database.orderDao.removePizzaFromCart(pizza.toCartPizzaDBO().cartPizzaId)
    }

    suspend fun makeOrder(order: Order, pizzaList: List<CartPizza>) {
        database.orderDao.placeOrder(order.toOrderDBO(), pizzaList.map { it.toCartPizzaDBO() })
    }
}