package dev.k.pizza_data

import android.util.Log
import dev.k.pizza_api.PizzaApi
import dev.k.pizza_data.mappers.toPizza
import dev.k.pizza_data.models.Pizza
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

public class PizzaRepository @Inject constructor(
    private val api: PizzaApi,
) {
    val remotePizza: Flow<List<Pizza>> = getCatalog()

    public fun getCatalog(): Flow<List<Pizza>> {
        return flow {
            val response = api.getCatalog()
            if (response.success)
                emit(response.catalog.map { it.toPizza() })
            else {
                Log.e(LOG_TAG, response.reason ?: "Unknown error")
                emit(emptyList())
            }
        }
    }

    public fun pay() {
        TODO("implement")
    }

    public fun getOrders() {
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