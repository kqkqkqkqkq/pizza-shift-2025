package dev.k.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.k.ui_utils.mappers.getSizeMap
import dev.k.ui_utils.models.PizzaSizeUI

@Composable
fun SizeSelector(
    sizes: List<PizzaSizeUI>,
    selectedIndex: Int,
    onOptionSelected: (Int) -> Unit
) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .background(
                Color(0xFFF5F6F7),
                shape = RoundedCornerShape(20.dp)
            )
            .border(1.dp, Color.LightGray, RoundedCornerShape(20.dp)),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        sizes.forEachIndexed { index, size ->
            val isSelected = index == selectedIndex

            TextButton(
                onClick = { onOptionSelected(index) },
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(20.dp))
                    .background(if (isSelected) Color.White else Color.Transparent)
            ) {
                Column(
                    modifier = Modifier,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = getSizeMap(size.name),
                        color = if (isSelected) Color.Black else Color.Gray,
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp,
                    )
                    Text(
                        text = "${size.price} ₽",
                        color = if (isSelected) Color.Black else Color.Gray,
                        fontWeight = FontWeight.Normal,
                        fontSize = 8.sp
                    )
                }

            }
        }
    }
}