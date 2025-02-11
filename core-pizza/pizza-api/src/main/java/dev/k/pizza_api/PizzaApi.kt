package dev.k.pizza_api

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dev.k.pizza_api.models.PizzaDTO
import dev.k.pizza_api.models.ResponseDTO
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit
import retrofit2.create
import retrofit2.http.GET

/**
 * [API Documentation](https://shift-intensive.ru/api)
 */
interface PizzaApi {
    @GET("catalog")
    suspend fun getCatalog(): ResponseDTO<PizzaDTO>
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