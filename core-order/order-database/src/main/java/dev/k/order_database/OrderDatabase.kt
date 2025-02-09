package dev.k.order_database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import dev.k.order_database.converters.Converters
import dev.k.order_database.dao.OrderDao
import dev.k.order_database.models.CartPizzaDBO
import dev.k.order_database.models.OrderDBO
import dev.k.order_database.models.OrderPizzaCrossRef

class OrderDatabase internal constructor(private val database: OrderRoomDatabase) {
    val orderDao: OrderDao
        get() = database.orderDao()
}

@Database(
    entities = [
        OrderDBO::class,
        CartPizzaDBO::class,
        OrderPizzaCrossRef::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
internal abstract class OrderRoomDatabase : RoomDatabase() {
    abstract fun orderDao(): OrderDao
}

fun OrderDatabase(applicationContext: Context): OrderDatabase {
    val orderRoomDatabase =
        Room.databaseBuilder(
            checkNotNull(applicationContext.applicationContext),
            OrderRoomDatabase::class.java,
            "order"
        ).build()
    return OrderDatabase(orderRoomDatabase)
}