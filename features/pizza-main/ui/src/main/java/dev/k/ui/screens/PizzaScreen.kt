package dev.k.ui.screens

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import dev.k.ui_logic.screens.pizza_screen.PizzaScreenState
import dev.k.ui_logic.screens.pizza_screen.PizzaScreenViewModel
import dev.k.ui.components.BottomNavigationBar
import dev.k.ui.components.ErrorMessage
import dev.k.ui.components.Header
import dev.k.ui.components.LoadingIndicator
import dev.k.ui.components.PizzaItemUI

@Composable
fun PizzaScreen(
    navController: NavHostController,
) {
    val viewModel: PizzaScreenViewModel = hiltViewModel()
    PizzaScreenUI(viewModel = viewModel, navController = navController)
}

@Composable
internal fun PizzaScreenUI(
    viewModel: PizzaScreenViewModel,
    navController: NavHostController,
) {
    val state by viewModel.state.collectAsState()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        },
        topBar = {
            Header("Пицца")
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = padding.calculateTopPadding(),
                    bottom = padding.calculateBottomPadding(),
                ),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            when (state) {
                is PizzaScreenState.Initial -> Unit
                is PizzaScreenState.Loading -> LoadingIndicator()
                is PizzaScreenState.Failure -> ErrorMessage((state as PizzaScreenState.Failure).message.toString())
                is PizzaScreenState.Content -> PizzaScreenContent(state as PizzaScreenState.Content, navController)
            }
        }

    }
}

@Composable
fun PizzaScreenContent(
    state: PizzaScreenState.Content,
    navController: NavHostController,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        items(state.pizzaList) { pizzaItem ->
            PizzaItemUI(pizzaItem, navController)
        }
    }
}