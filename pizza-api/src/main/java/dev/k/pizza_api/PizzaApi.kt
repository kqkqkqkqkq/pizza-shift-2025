package dev.k.pizza_api

import dev.k.pizza_api.models.PizzaDTO
import dev.k.pizza_api.models.ResponseDTO
import retrofit2.Retrofit
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query


/**
 * [API Documentation]()
 */
interface PizzaApi {
    @GET("/catalog")
    suspend fun getCatalog():Result<ResponseDTO<PizzaDTO>>

    @POST("/payment")
    suspend fun pay()

    @GET("/orders")
    suspend fun getOrders(
        @Header("authorization") authorization: String,
    )

    @GET("/orders/{orderId}")
    suspend fun getOrderById(
        @Header("authorization") authorization: String,
        @Path("orderId") orderId: String,
    )

    @PUT("/orders/cancel")
    suspend fun cancelOrder(
        @Header("authorization") authorization: String,
    )
}

fun PizzaApi(
    baseUrl: String,
): PizzaApi {
    return retrofit(baseUrl).create()
}

private fun retrofit(
    baseUrl: String,
): Retrofit {
    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .build()
}