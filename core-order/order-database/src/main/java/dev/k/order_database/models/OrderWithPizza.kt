package dev.k.order_database.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Junction
import androidx.room.Relation

@Entity(
    primaryKeys = ["orderId", "cartPizzaId"]
)
data class OrderPizzaCrossRef(
    val orderId: Long,
    val cartPizzaId: Long,
)

data class OrderWithPizza(
    @Embedded val order: OrderDBO,
    @Relation(
        parentColumn = "orderId",
        entityColumn = "cartPizzaId",
        associateBy = Junction(OrderPizzaCrossRef::class)
    )
    val pizzaList: List<CartPizzaDBO>,
)