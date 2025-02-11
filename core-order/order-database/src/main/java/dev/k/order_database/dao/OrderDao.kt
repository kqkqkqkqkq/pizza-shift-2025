package dev.k.order_database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import dev.k.order_database.models.CartPizzaDBO
import dev.k.order_database.models.OrderDBO
import dev.k.order_database.models.OrderPizzaCrossRef

@Dao
interface OrderDao {

//    @Transaction
//    @Query("SELECT * FROM orders")
//    suspend fun getOrdersWithPizza(): List<OrderWithPizza>

    @Query("SELECT * FROM cart")
    suspend fun getCart(): List<CartPizzaDBO>

    @Insert
    suspend fun insertOrder(order: OrderDBO): Long = order.orderId

    @Insert
    suspend fun insertOrderPizzaCrossRef(refs: List<OrderPizzaCrossRef>)

    @Transaction
    suspend fun placeOrder(order: OrderDBO, pizzas: List<CartPizzaDBO>) {
        val orderId = insertOrder(order)
        val refs = pizzas.map { pizza ->
            OrderPizzaCrossRef(orderId, pizza.cartPizzaId)
        }
        insertOrderPizzaCrossRef(refs)
    }

    @Insert //TODO("добавлять в корзину нужно тогда,
    // когда нет элемента с одинаковыми добавками/тестом/размером, если есть одинаковые, то нужно обновлять количество")
    suspend fun insertCartPizza(pizza: CartPizzaDBO)

    @Query("DELETE FROM cart WHERE cartPizzaId = :id") //TODO("fix: удаление по id не работает")
    suspend fun removePizzaFromCart(id: Long)

    @Query("DELETE FROM orders")
    suspend fun cleanOrders()

    @Query("DELETE FROM cart")
    suspend fun cleanCart()
}