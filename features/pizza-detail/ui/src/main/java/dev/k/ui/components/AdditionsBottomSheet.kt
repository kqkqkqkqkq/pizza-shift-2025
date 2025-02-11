package dev.k.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.k.ui_kit.theme.Black
import dev.k.ui_kit.theme.PizzaTheme
import dev.k.ui_logic.PizzaDetailVewModel
import dev.k.ui_utils.models.PizzaIngredientUI

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdditionsBottomSheet(
    viewModel: PizzaDetailVewModel,
    additives: List<PizzaIngredientUI>,
    isBottomSheetVisible: Boolean,
    sheetState: SheetState,
    onDismiss: () -> Unit
) {
    if (isBottomSheetVisible) {
        ModalBottomSheet(
            onDismissRequest = onDismiss,
            sheetState = sheetState,
            containerColor = PizzaTheme.colorScheme.background,
            contentColor = PizzaTheme.colorScheme.onBackground,
            dragHandle = null,
            scrimColor = Black.copy(alpha = 0.5f),
            windowInsets = WindowInsets(0, 0, 0, 0)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.6f)
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Text(
                    text = "Добавить по вкусу",
                    style = PizzaTheme.typography.titleLarge,
                    color = PizzaTheme.colorScheme.onBackground,
                )
                AdditivesGrid(viewModel, additives)
            }
        }
    }
}