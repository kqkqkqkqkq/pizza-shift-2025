package dev.k.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.k.ui_kit.theme.PizzaTheme
import dev.k.ui_utils.mappers.getDoughMap
import dev.k.ui_utils.mappers.getSizeMap

@Composable
fun Selector(
    data: List<Pair<String, Int>>,
    dataType: SelectorDataTypes,
    selectedIndex: Int,
    onOptionSelected: (Int) -> Unit
) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .background(
                PizzaTheme.colorScheme.secondary.copy(0.3f),
                RoundedCornerShape(20.dp),
            )
            .border(
                1.dp,
                PizzaTheme.colorScheme.secondary.copy(0.3f),
                RoundedCornerShape(20.dp),
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        data.forEachIndexed { index, data ->
            val isSelected = index == selectedIndex
            val textColor = if (isSelected)
                PizzaTheme.colorScheme.onSecondary else PizzaTheme.colorScheme.secondary
            val title = when (dataType) {
                SelectorDataTypes.SIZE -> getSizeMap(data.first)
                SelectorDataTypes.DOUGH -> getDoughMap(data.first)
            }
            TextButton(
                onClick = { onOptionSelected(index) },
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.textButtonColors(
                    containerColor = if (isSelected)
                        PizzaTheme.colorScheme.background else Color.Transparent,
                )
            ) {
                Column(
                    modifier = Modifier,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = title,
                        color = textColor,
                        style = PizzaTheme.typography.titleSmall,
                    )
                    Text(
                        text = "${data.second} ₽",
                        color = textColor,
                        style = PizzaTheme.typography.labelSmall,
                    )
                }
            }
        }
    }
}