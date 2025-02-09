package dev.k.shift

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.k.order_database.OrderDatabase
import dev.k.pizza_api.PizzaApi
import dev.k.pizza_api.createPizzaApi
import dev.k.pizza_database.PizzaDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providePizzaApi(): PizzaApi = createPizzaApi(
        baseUrl = BuildConfig.PIZZA_API_BASE_URL
    )

    @Provides
    @Singleton
    fun providePizzaDatabase(
        @ApplicationContext context: Context
    ): PizzaDatabase = PizzaDatabase(context)

    @Provides
    @Singleton
    fun provideOrderDatabase(
        @ApplicationContext context: Context
    ): OrderDatabase = OrderDatabase(context)
}