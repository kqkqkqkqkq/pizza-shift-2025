package dev.k.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import dev.k.ui_logic.MakeOrderViewModel

@Composable
fun MakeOrderUserScreen(
    navController: NavHostController,
) {
    val viewModel: MakeOrderViewModel = hiltViewModel()
    MakeOrderUserScreenUI(viewModel, navController)
}

@Composable
private fun MakeOrderUserScreenUI(
    viewModel: MakeOrderViewModel,
    navController: NavHostController,
) {
    Column {
        Button(
            onClick = {
                viewModel.makeOrder()
            }
        ) {
            Text("Заказ")
        }
    }
}