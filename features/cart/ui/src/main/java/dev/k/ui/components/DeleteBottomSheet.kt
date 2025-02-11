package dev.k.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dev.k.features.cart.ui.R
import dev.k.ui_kit.theme.Black
import dev.k.ui_kit.theme.PizzaTheme
import dev.k.ui_kit.theme.Red
import dev.k.ui_logic.CartScreenViewModel
import dev.k.ui_utils.models.PizzaUI

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeleteBottomSheet(
    pizza: PizzaUI,
    isBottomSheetVisible: Boolean,
    sheetState: SheetState,
    onDismiss: () -> Unit,
    viewModel: CartScreenViewModel,
) {
    //TODO("Переделать элемент удаления из корзины")
    if (isBottomSheetVisible) {
        ModalBottomSheet(
            onDismissRequest = onDismiss,
            sheetState = sheetState,
            containerColor = Red,
            dragHandle = { BottomSheetDefaults.DragHandle() },
            scrimColor = Black.copy(alpha = 0.5f),
            windowInsets = WindowInsets(0, 0, 0, 0)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.1f),
                contentAlignment = Alignment.TopCenter,
            ) {
                TextButton(
                    modifier = Modifier,
                    colors = ButtonDefaults.textButtonColors(
                        contentColor = PizzaTheme.colorScheme.background,
                    ),
                    shape = RoundedCornerShape(12.dp),
                    onClick = {
                        viewModel.deleteFromCart(pizza)
                    }
                ) {
                    Text(
                        text = stringResource(R.string.delete_message),
                        style = PizzaTheme.typography.titleLarge,
                    )
                }
            }
        }
    }
}