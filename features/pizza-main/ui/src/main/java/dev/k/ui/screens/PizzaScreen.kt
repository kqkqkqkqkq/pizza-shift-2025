package dev.k.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import dev.k.ui_logic.screens.pizza_screen.PizzaScreenState
import dev.k.ui_logic.screens.pizza_screen.PizzaScreenViewModel
import dev.k.ui.components.BottomNavigationBar
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
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = padding.calculateBottomPadding()),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            PizzaScreenHeader()
            when (state) {
                is PizzaScreenState.Initial -> Unit
                is PizzaScreenState.Loading -> LoadingIndicator()
                is PizzaScreenState.Failure -> ErrorMessage(state as PizzaScreenState.Failure)
                is PizzaScreenState.Content -> PizzaScreenContent(state as PizzaScreenState.Content, navController)
            }
        }

    }
}

@Composable
fun PizzaScreenHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp + 8.dp)
            .padding(top = 12.dp, start = 16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = "Пицца",
            color = Color.Black,
            fontSize = 32.sp,
            fontWeight = FontWeight.Medium,
        )
    }
    Spacer(modifier = Modifier.height(12.dp))
}

@Composable
fun LoadingIndicator() {
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }
}

@Composable
fun ErrorMessage(state: PizzaScreenState.Failure) {
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(state.message.toString())
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