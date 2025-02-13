package dev.k.ui

import android.widget.Space
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
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
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import dev.k.features.pizza_detail.ui.R
import dev.k.ui.components.AdditionsBottomSheet
import dev.k.ui.components.DoughSelector
import dev.k.ui.components.SizeSelector
import dev.k.ui_kit.Destinations
import dev.k.ui_kit.components.TopBar
import dev.k.ui_kit.theme.Green
import dev.k.ui_kit.theme.PizzaTheme
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
    val snackbarMessage = stringResource(R.string.snackbar_message)

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
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 32.dp),
                contentAlignment = Alignment.TopCenter,
            ) {
                SnackbarHost(
                    hostState = snackbarHostState,
                    snackbar = {
                        Snackbar(
                            modifier = Modifier
                                .fillMaxWidth(0.9f)
                                .border(
                                    1.dp,
                                    PizzaTheme.colorScheme.onBackground,
                                    RoundedCornerShape(12.dp),
                                ),
                            shape = RoundedCornerShape(12.dp),
                            containerColor = PizzaTheme.colorScheme.background,
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 12.dp),
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                verticalAlignment = Alignment.CenterVertically,
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Check,
                                    tint = Green,
                                    contentDescription = "SnackBar Icon",
                                    modifier = Modifier.size(20.dp),
                                )
                                Text(
                                    text = snackbarMessage,
                                    style = PizzaTheme.typography.titleSmall,
                                    color = PizzaTheme.colorScheme.onBackground,
                                )
                            }
                        }
                    }
                )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = padding.calculateTopPadding(),
                    start = 8.dp,
                    bottom = padding.calculateBottomPadding(),
                    end = 8.dp,
                ),
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
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 16.dp,
                        end = 16.dp,
                        bottom = 16.dp,
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ) {
                OutlinedButton(
                    modifier = Modifier
                        .fillMaxWidth(0.5f),
                    shape = RoundedCornerShape(
                        topStart = 16.dp,
                        topEnd = 0.dp,
                        bottomStart = 16.dp,
                        bottomEnd = 0.dp,
                    ),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = PizzaTheme.colorScheme.background,
                    ),
                    border = BorderStroke(
                        2.dp,
                        PizzaTheme.colorScheme.secondary,
                    ),
                    onClick = {
                        scope.launch {
                            isBottomSheetVisible = true
                            sheetState.expand()
                        }
                    }
                ) {
                    Text(
                        text = stringResource(R.string.additives),
                        color = PizzaTheme.colorScheme.secondary,
                        style = PizzaTheme.typography.bodyLarge,
                    )
                }
                OutlinedButton(
                    modifier = Modifier
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(
                        topStart = 0.dp,
                        topEnd = 16.dp,
                        bottomStart = 0.dp,
                        bottomEnd = 16.dp,
                    ),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = PizzaTheme.colorScheme.primary,
                    ),
                    border = BorderStroke(
                        2.dp,
                        PizzaTheme.colorScheme.primary,
                    ),
                    onClick = {
                        viewModel.insert(pizza)
                        scope.launch {
                            snackbarHostState.showSnackbar(snackbarMessage)
                        }
                    }
                ) {
                    Text(
                        text = stringResource(R.string.add_to_cart),
                        color = PizzaTheme.colorScheme.onPrimary,
                        style = PizzaTheme.typography.bodyLarge,
                    )
                }
            }
        }
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