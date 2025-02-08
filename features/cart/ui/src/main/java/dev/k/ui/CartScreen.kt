package dev.k.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import dev.k.features.cart.ui.R
import dev.k.ui.components.CartItem
import dev.k.ui_kit.components.BottomNavigationBar
import dev.k.ui_kit.components.TopBar
import dev.k.ui_kit.theme.Orange
import dev.k.ui_kit.theme.White
import dev.k.ui_logic.CartScreenViewModel
import dev.k.ui_utils.models.PizzaUI

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
            CartScreenContent(viewModel, state.toList())
        }
    }
}

@Composable
fun CartScreenContent(
    viewModel: CartScreenViewModel,
    cartList: List<PizzaUI>,
) {
    if (cartList.isNotEmpty()) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 12.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                items(cartList) {
                    CartItem(it, viewModel)
                }
            }
            // TODO()
            OrderElement()
        }
    } else {
        CartScreenEmpty()
    }
}

@Composable
fun CartScreenEmpty() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(stringResource(R.string.empty_cart))
    }
}

@Composable
fun OrderElement() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(128.dp),
        colors = CardDefaults.cardColors(
            containerColor = White,
        ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .height(42.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(stringResource(R.string.order_cost))
                Spacer(modifier = Modifier.weight(1f))
                Text("1200 ₽")
            }
            TextButton(
                modifier = Modifier
                    .fillMaxWidth(0.75f),
                onClick = {
                    TODO("Navigate to make order screen")
                },
                colors = ButtonDefaults.textButtonColors(
                    containerColor = Orange,
                )
            ) {
                Text(
                    color = White,
                    text = stringResource(R.string.make_order),
                )
            }
        }
    }
}