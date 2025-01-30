package dev.k.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import dev.k.domain.PizzaScreenState
import dev.k.domain.PizzaScreenViewModel
import dev.k.ui.components.BottomNavigationBar
import dev.k.ui.components.PizzaItemUI

@Composable
fun PizzaScreen(
    navController: NavHostController,
) {
    val viewModel: PizzaScreenViewModel = hiltViewModel()
    PizzaScreenUI(viewModel = viewModel, navController = navController)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
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
    ) {
        when (state) {
            is PizzaScreenState.Initial -> Unit
            is PizzaScreenState.Loading -> LoadingIndicator()
            is PizzaScreenState.Failure -> ErrorMessage(state as PizzaScreenState.Failure)
            is PizzaScreenState.Content -> PizzaScreenContent(state as PizzaScreenState.Content)
        }
    }
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
    state: PizzaScreenState.Content
) {
    val pizzaList = state.pizzaList
    LazyColumn {
        items(pizzaList) {
            PizzaItemUI(it)
        }
    }
}