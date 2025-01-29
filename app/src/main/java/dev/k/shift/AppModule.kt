package dev.k.shift

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.k.pizza_api.PizzaApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providePizzaApi(): PizzaApi = PizzaApi(
        baseUrl = BuildConfig.PIZZA_API_BASE_URL
    )
}