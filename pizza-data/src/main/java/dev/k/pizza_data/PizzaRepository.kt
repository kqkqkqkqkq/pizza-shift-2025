package dev.k.pizza_data

import android.util.Log
import dev.k.pizza_api.PizzaApi
import dev.k.pizza_data.mappers.toPizza
import dev.k.pizza_data.mappers.toPizzaDBO
import dev.k.pizza_data.models.Pizza
import dev.k.pizza_database.PizzaDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PizzaRepository @Inject constructor(
    private val database: PizzaDatabase,
    private val api: PizzaApi,
) {

    fun getCart(): Flow<List<Pizza>> = flow {
        emit(database.pizzaDao.getAll().map { it.toPizza() })
    }.flowOn(Dispatchers.IO)


    suspend fun insertToCars(data: Pizza) {
        database.pizzaDao.insert(data.toPizzaDBO())
    }

    suspend fun removeFromCart(data: Pizza) {
        database.pizzaDao.remove(data.toPizzaDBO())
    }

    suspend fun clearCart() {
        database.pizzaDao.clean()
    }

    fun getCatalog(): Flow<List<Pizza>> =
        flow {
            val response = api.getCatalog()
            if (response.success)
                emit(response.catalog.map { it.toPizza() })
            else {
                Log.e(LOG_TAG, response.reason ?: "Unknown error")
                emit(emptyList())
            }
    }

    suspend fun pay() {
        api.pay()
    }

    fun getOrders() {
        TODO("implement")
        // @Header("authorization")
        // authorization: String, )
    }

    public fun getOderById() {
        TODO("implement")
        // @Header("authorization") authorization: String,
        // @Path("orderId") orderId: String, )
    }

    public fun cancelOrder() {
        TODO("implement")
        // @Header("authorization") authorization: String, )
    }

    private companion object {
        const val LOG_TAG = "ArticlesRepository"
    }
}