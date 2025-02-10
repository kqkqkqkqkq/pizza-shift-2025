package dev.k.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import dev.k.ui_logic.PizzaDetailVewModel
import dev.k.ui_utils.models.PizzaIngredientUI

@Composable
fun AdditivesGrid(
    viewModel: PizzaDetailVewModel,
    additives: List<PizzaIngredientUI>,
) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(additives) { item ->
            var isSelected by remember { mutableStateOf(item.isSelected) }
            Box {
                AdditiveItem(
                    name = item.name,
                    price = item.cost.toString(),
                    image = item.img,
                    isSelected = isSelected,
                    onClick = {
                        viewModel.selectAdditions(item)
                        isSelected = !isSelected
                    }
                )
            }
        }
    }
}