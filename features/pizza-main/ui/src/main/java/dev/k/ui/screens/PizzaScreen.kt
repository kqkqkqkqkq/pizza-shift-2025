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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import dev.k.ui.R
import dev.k.ui.components.BottomNavigationBar
import dev.k.ui.components.ErrorMessage
import dev.k.ui.components.Header
import dev.k.ui.components.LoadingIndicator
import dev.k.ui.components.PizzaItemUI
import dev.k.ui_logic.models.PizzaUI
import dev.k.ui_logic.screens.pizza_screen.PizzaScreenState
import dev.k.ui_logic.screens.pizza_screen.PizzaScreenViewModel

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
            Header(stringResource(R.string.pizza))
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
            when (val currentState = state) {
                is PizzaScreenState.Initial -> Unit
                is PizzaScreenState.Loading -> LoadingIndicator()
                is PizzaScreenState.Failure -> ErrorMessage(currentState.message.toString())
                is PizzaScreenState.Content -> PizzaScreenContent(
                    currentState.pizzaList,
                    navController
                )
            }
        }
    }
}

@Composable
fun PizzaScreenContent(
    pizzaList: List<PizzaUI>,
    navController: NavHostController,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        items(pizzaList) { pizzaItem ->
            PizzaItemUI(pizzaItem, navController)
        }
    }
}