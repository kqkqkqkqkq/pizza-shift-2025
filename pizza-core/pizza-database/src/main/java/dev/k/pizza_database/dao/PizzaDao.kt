package dev.k.pizza_database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import dev.k.pizza_database.models.PizzaDBO

@Dao
interface PizzaDao {
    @Query("SELECT * FROM pizzas")
    suspend fun getAll(): List<PizzaDBO>

    @Insert(onConflict = REPLACE)
    suspend fun insert(pizza: PizzaDBO)

    @Delete
    suspend fun remove(pizza: PizzaDBO)

    @Query("DELETE FROM pizzas WHERE name = :name")
    suspend fun removeByName(name: String)

    @Query("DELETE FROM pizzas")
    suspend fun clean()
}