package dev.k.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.k.domain.MainScreenViewModel

@Composable
fun MainScreen() {
    MainScreenContent(viewModel = viewModel())
}

@Composable
internal fun MainScreenContent(viewModel: MainScreenViewModel) {
    TODO("сделать Ui-kit, потом верстка")
}