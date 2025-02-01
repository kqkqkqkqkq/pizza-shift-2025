package dev.k.pizza_database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import dev.k.pizza_database.models.PizzaDBO

@Dao
interface PizzaDao {
    @Query("SELECT * FROM pizzas")
    suspend fun getAll(): List<PizzaDBO>

    @Insert
    suspend fun insert(articles: List<PizzaDBO>)

    @Delete
    suspend fun remove(articles: List<PizzaDBO>)

    @Query("DELETE FROM pizzas")
    suspend fun clean()
}

