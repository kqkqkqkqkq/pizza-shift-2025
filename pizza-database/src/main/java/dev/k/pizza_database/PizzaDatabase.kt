package dev.k.pizza_database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dev.k.pizza_database.dao.PizzaDao
import dev.k.pizza_database.models.PizzaDBO

class PizzaDatabase internal constructor(private val database: PizzaRoomDatabase) {
    val pizzaDao: PizzaDao
        get() = database.pizzaDao()
}

@Database(entities = [PizzaDBO::class], version = 1, exportSchema = false)
internal abstract class PizzaRoomDatabase: RoomDatabase() {
    abstract fun pizzaDao(): PizzaDao
}

fun PizzaDatabase(applicationContext: Context): PizzaDatabase {
    val pizzaRoomDatabase =
        Room.databaseBuilder(
            checkNotNull(applicationContext.applicationContext),
            PizzaRoomDatabase::class.java,
            "pizza"
        ).build()
    return PizzaDatabase(pizzaRoomDatabase)
}