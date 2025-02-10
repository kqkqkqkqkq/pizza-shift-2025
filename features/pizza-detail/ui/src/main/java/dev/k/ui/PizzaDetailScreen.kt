package dev.k.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import dev.k.features.pizza_detail.ui.R
import dev.k.ui.components.AdditionsBottomSheet
import dev.k.ui.components.DoughSelector
import dev.k.ui.components.SizeSelector
import dev.k.ui_kit.Destinations
import dev.k.ui_kit.components.TopBar
import dev.k.ui_kit.theme.Orange
import dev.k.ui_kit.theme.PizzaTheme
import dev.k.ui_kit.theme.White
import dev.k.ui_logic.PizzaDetailVewModel
import dev.k.ui_utils.models.PizzaUI
import kotlinx.coroutines.launch

@Composable
fun PizzaDetailScreen(
    pizza: PizzaUI,
    navController: NavHostController,
) {
    val viewModel: PizzaDetailVewModel = hiltViewModel()
    PizzaDetailScreenUI(pizza, viewModel, navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun PizzaDetailScreenUI(
    pizza: PizzaUI,
    viewModel: PizzaDetailVewModel,
    navController: NavHostController,
) {
    val selectedSize by viewModel.selectedSize.collectAsState()
    val selectedDough by viewModel.selectedDough.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }
    var isBottomSheetVisible by rememberSaveable { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopBar(text = stringResource(R.string.pizza), onClick = {
                navController.navigate(Destinations.PIZZA_SCREEN) {
                    popUpTo(Destinations.PIZZA_DETAIL_SCREEN) {
                        inclusive = true
                    }
                }
            })
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
                    .padding(top = 12.dp),
                contentAlignment = Alignment.Center,
            ) {
                AsyncImage(
                    modifier = Modifier.size(220.dp),
                    model = pizza.img,
                    contentDescription = "Pizza detail image"
                )
            }
            Text(
                text = pizza.name,
                color = PizzaTheme.colorScheme.onBackground,
                style = PizzaTheme.typography.titleLarge,
            )
            Text(
                text = pizza.description,
                color = PizzaTheme.colorScheme.secondary,
                style = PizzaTheme.typography.bodyLarge,
            )
            SizeSelector(
                sizes = pizza.sizes,
                selectedIndex = selectedSize,
                onOptionSelected = { viewModel.selectSize(it) }
            )
            DoughSelector(
                doughs = pizza.doughs,
                selectedIndex = selectedDough,
                onOptionSelected = { viewModel.selectDough(it) }
            )
            Spacer(modifier = Modifier.weight(1f))
            TextButton(
                modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .padding(vertical = 24.dp),
                onClick = {
                    scope.launch {
                        isBottomSheetVisible = true
                        sheetState.expand()
                    }
                },
                colors = ButtonDefaults.textButtonColors(
                    containerColor = PizzaTheme.colorScheme.secondary,
                )
            ) {
                Text(
                    color = PizzaTheme.colorScheme.onSecondary,
                    text = stringResource(R.string.add_to_taste),
                )
            }
            TextButton(
                modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .padding(vertical = 24.dp),
                onClick = {
                    viewModel.insert(pizza)
                    scope.launch {
                        snackbarHostState.showSnackbar(
                            "Пицца добавлена в корзину"
                        )
                    }
                },
                colors = ButtonDefaults.textButtonColors(
                    containerColor = PizzaTheme.colorScheme.primary,
                )
            ) {
                Text(
                    color = PizzaTheme.colorScheme.onPrimary,
                    text = stringResource(R.string.add_to_cart),
                )
            }
            AdditionsBottomSheet(
                viewModel = viewModel,
                additives = pizza.toppings,
                isBottomSheetVisible = isBottomSheetVisible,
                sheetState = sheetState,
                onDismiss = {
                    scope.launch { sheetState.hide() }
                        .invokeOnCompletion { isBottomSheetVisible = false }
                }
            )
        }
    }
}