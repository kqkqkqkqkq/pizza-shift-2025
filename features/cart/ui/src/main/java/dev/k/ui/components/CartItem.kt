package dev.k.ui.components

import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowRight
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import dev.k.features.cart.ui.R
import dev.k.ui_kit.theme.PizzaTheme
import dev.k.ui_logic.CartScreenViewModel
import dev.k.ui_utils.models.PizzaUI
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartItem(
    pizza: PizzaUI,
    viewModel: CartScreenViewModel,
) {
    var isBottomSheetVisible by rememberSaveable { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )
    val scope = rememberCoroutineScope()

    var quantity by remember { mutableStateOf(pizza.quantity) }

    var icon by remember { mutableStateOf(Icons.Outlined.Delete) }

    icon = if (pizza.quantity <= 1) Icons.Outlined.Delete
    else Icons.AutoMirrored.Rounded.KeyboardArrowLeft

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(92.dp)
            .padding(8.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(64.dp),
            contentAlignment = Alignment.Center,
        ) {
            AsyncImage(
                model = pizza.img,
                contentDescription = pizza.name,
                modifier = Modifier.fillMaxSize(),
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            Text(
                text = pizza.name,
                color = PizzaTheme.colorScheme.onBackground,
                style = PizzaTheme.typography.titleSmall,
                modifier = Modifier.padding(horizontal = 8.dp),
            )
            Text(
                text = "Описание и добавки",
                color = PizzaTheme.colorScheme.secondary,
                style = PizzaTheme.typography.bodySmall,
                modifier = Modifier.padding(horizontal = 8.dp),
            )
            Spacer(modifier = Modifier.weight(1f))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
            ) {
                Row(
                    modifier = Modifier
                        .wrapContentSize()
                        .height(24.dp)
                        .background(
                            shape = RoundedCornerShape(16.dp),
                            color = PizzaTheme.colorScheme.secondary.copy(alpha = 0.2f)
                        )
                        .padding(horizontal = 4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                ) {
                    IconButton(
                        onClick = {
                            if (quantity > 1) {
                                viewModel.decreaseQuantity(pizza)
                                quantity--
                            }
                            else {
                                scope.launch {
                                    isBottomSheetVisible = true
                                    sheetState.expand()
                                }
                            }
                        }
                    ) {
                        Icon(
                            icon,
                            tint = PizzaTheme.colorScheme.onSecondary,
                            contentDescription = "Decrease",
                        )
                    }
                    Text(
                        text = quantity.toString(),
                        color = PizzaTheme.colorScheme.onBackground,
                        style = PizzaTheme.typography.bodySmall,
                    )
                    IconButton(
                        onClick = {
                            viewModel.increaseQuantity(pizza)
                            quantity++
                        }
                    ) {
                        Icon(
                            Icons.AutoMirrored.Rounded.KeyboardArrowRight,
                            tint = PizzaTheme.colorScheme.onSecondary,
                            contentDescription = "Increase",
                        )
                    }
                }
                TextButton(
                    onClick = {
                        TODO("Bottom sheet элемент для редактирования")
                    }
                ) {
                    Text(
                        text = stringResource(R.string.change),
                        color = PizzaTheme.colorScheme.secondary,
                        style = PizzaTheme.typography.bodyLarge,
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "${pizza.cost * quantity} ₽",
                    color = PizzaTheme.colorScheme.onBackground,
                    style = PizzaTheme.typography.bodyLarge,
                )
            }
        }
    }
    DeleteBottomSheet(
        pizza = pizza,
        isBottomSheetVisible = isBottomSheetVisible,
        sheetState = sheetState,
        onDismiss = {
            scope.launch { sheetState.hide() }
                .invokeOnCompletion { isBottomSheetVisible = false }
        },
        viewModel = viewModel,
    )
}