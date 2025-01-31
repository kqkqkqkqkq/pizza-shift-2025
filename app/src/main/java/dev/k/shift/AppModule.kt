package dev.k.shift

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.k.pizza_api.PizzaApi
import dev.k.pizza_api.createPizzaApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providePizzaApi(): PizzaApi = createPizzaApi(
        baseUrl = BuildConfig.PIZZA_API_BASE_URL
    )
}