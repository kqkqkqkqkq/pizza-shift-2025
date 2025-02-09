package dev.k.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import dev.k.ui_logic.PizzaDetailVewModel
import dev.k.ui_utils.models.PizzaIngredientUI

@Composable
fun AdditivesGrid(
    viewModel: PizzaDetailVewModel,
    additives: List<PizzaIngredientUI>,
) {
    val selectedItems by viewModel.selectedAdditions.collectAsState()

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(additives) { item ->
            val isSelected = selectedItems.contains(item.name)
            Box {
                AdditiveItem(
                    name = item.name,
                    price = item.cost.toString(),
                    image = item.img,
                    isSelected = isSelected,
                    onClick = {
                        val updatedSelection = if (isSelected) {
                            selectedItems - item.name
                        } else {
                            selectedItems + item.name
                        }
                        viewModel.selectAdditions(updatedSelection)
                    }
                )
            }
        }
    }
}