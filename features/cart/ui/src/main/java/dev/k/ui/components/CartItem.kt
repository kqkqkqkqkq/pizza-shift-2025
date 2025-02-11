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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import dev.k.ui_kit.theme.PizzaTheme
import dev.k.ui_logic.CartScreenViewModel
import dev.k.ui_utils.models.PizzaUI

@Composable
fun CartItem(
    viewModel: CartScreenViewModel,
    pizza: PizzaUI,
) {
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
                        onClick = { /* Уменьшить количество */ }
                    ) {
                        Icon(
                            Icons.AutoMirrored.Rounded.KeyboardArrowLeft,
                            tint = PizzaTheme.colorScheme.onSecondary,
                            contentDescription = "Decrease",
                        )
                    }
                    Text(
                        text = pizza.quantity.toString(),
                        color = PizzaTheme.colorScheme.onBackground,
                        style = PizzaTheme.typography.bodySmall,
                    )
                    IconButton(
                        onClick = { /* Увеличить количество */ }
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

                    }
                ) {
                    Text(
                        text = "Изменить",
                        color = PizzaTheme.colorScheme.secondary,
                        style = PizzaTheme.typography.bodyLarge,
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "${pizza.cost} ₽",
                    color = PizzaTheme.colorScheme.onBackground,
                    style = PizzaTheme.typography.bodyLarge,
                )
            }
        }
    }
}