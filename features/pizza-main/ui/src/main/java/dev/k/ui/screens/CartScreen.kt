package dev.k.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import dev.k.ui.components.BottomNavigationBar
import dev.k.ui.components.CartItem
import dev.k.ui.components.ErrorMessage
import dev.k.ui.components.Header
import dev.k.ui.components.LoadingIndicator
import dev.k.ui.components.PizzaItemUI
import dev.k.ui_logic.models.PizzaUI
import dev.k.ui_logic.screens.cart_screen.CartScreenState
import dev.k.ui_logic.screens.cart_screen.CartScreenViewModel
import javax.annotation.meta.When

@Composable
fun CartScreen(
    navController: NavHostController,
) {
    val viewModel: CartScreenViewModel = hiltViewModel()
    CartScreenUI(viewModel, navController = navController)
}

@Composable
internal fun CartScreenUI(
    viewModel: CartScreenViewModel,
    navController: NavHostController,
) {
    val state by viewModel.state.collectAsState()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        },
        topBar = {
            Header("Корзина")
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = padding.calculateTopPadding(),
                    start = 12.dp,
                    bottom = padding.calculateBottomPadding(),
                    end = 12.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            when(val state = state) {
                is CartScreenState.Initial -> Unit
                is CartScreenState.Loading -> LoadingIndicator()
                is CartScreenState.Failure -> ErrorMessage(state.message.toString())
                is CartScreenState.Content -> CartScreenContent(state.cartList)
            }
        }
    }
}

@Composable
fun CartScreenContent(
    cartList: List<PizzaUI>,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        items(cartList) {
            CartItem(it)
        }
    }
}