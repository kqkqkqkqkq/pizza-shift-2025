package dev.k.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import dev.k.features.cart.ui.R
import dev.k.ui.components.CartItem
import dev.k.ui.components.OrderElement
import dev.k.ui_kit.components.BottomNavigationBar
import dev.k.ui_kit.components.ErrorMessage
import dev.k.ui_kit.components.LoadingIndicator
import dev.k.ui_kit.components.TopBar
import dev.k.ui_logic.CartScreenState
import dev.k.ui_logic.CartScreenViewModel
import dev.k.ui_utils.models.PizzaUI

@Composable
fun CartScreen(
    navController: NavHostController,
) {
    val viewModel: CartScreenViewModel = hiltViewModel()
    CartScreenUI(viewModel = viewModel, navController = navController)
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
            TopBar(stringResource(R.string.cart))
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = padding.calculateTopPadding(),
                    bottom = padding.calculateBottomPadding(),
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            when (val currentState = state) {
                is CartScreenState.Initial -> Unit
                is CartScreenState.Loading -> LoadingIndicator()
                is CartScreenState.Failure -> ErrorMessage(currentState.message.toString())
                is CartScreenState.Content -> CartScreenContent(
                    currentState.cart,
                    viewModel,
                    navController
                )
            }
        }
    }
}

@Composable
fun CartScreenContent(
    cartList: List<PizzaUI>,
    viewModel: CartScreenViewModel,
    navController: NavHostController,
) {
    val isEmptyList by remember { mutableStateOf(cartList.isEmpty()) }
    var cost by remember { mutableIntStateOf(cartList.sumOf { it.cost }) }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 8.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            items(cartList) { pizza ->
                CartItem(pizza, viewModel)
            }
        }
        OrderElement(
            cost = cost,
            navController = navController,
        )
    }
}