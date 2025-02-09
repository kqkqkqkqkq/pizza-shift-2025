package dev.k.order_database.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "orders")
data class OrderDBO(
    @PrimaryKey(autoGenerate = true)
    val orderId: Long = 0,
    val time: Date,
    val status: String,
    val price: Int,
    @Embedded val customer: CustomerDBO,
)