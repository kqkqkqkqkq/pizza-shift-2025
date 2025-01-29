package dev.k.pizza_api

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dev.k.pizza_api.models.PizzaDTO
import dev.k.pizza_api.models.ResponseDTO
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path


/**
 * [API Documentation](https://shift-intensive.ru/api)
 */
interface PizzaApi {
    @GET("catalog")
    suspend fun getCatalog():ResponseDTO<PizzaDTO>

    @POST("payment")
    suspend fun pay()

    @GET("orders")
    suspend fun getOrders(
        @Header("authorization") authorization: String,
    )

    @GET("orders/{orderId}")
    suspend fun getOrderById(
        @Header("authorization") authorization: String,
        @Path("orderId") orderId: String,
    )

    @PUT("orders/cancel")
    suspend fun cancelOrder(
        @Header("authorization") authorization: String,
    )
}

fun createPizzaApi(
    baseUrl: String,
): PizzaApi = retrofit(baseUrl, Json).create()


private fun retrofit(
    baseUrl: String,
    json: Json,
): Retrofit {
    val jsonConverterFactory = json.asConverterFactory(MediaType.get("application/json"))

    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(jsonConverterFactory)
        .build()
}