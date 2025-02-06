package dev.k.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import dev.k.ui_kit.PizzaTheme
import dev.k.ui_logic.models.PizzaUI
import dev.k.ui_logic.screens.cart_screen.CartScreenViewModel

@Composable
fun CartItem(
    pizza: PizzaUI,
    viewModel: CartScreenViewModel,
) {
    val quantity = viewModel.quantity.collectAsState()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = pizza.img,
            contentDescription = "Cart",
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(16.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = pizza.name,
                style = PizzaTheme.typography.titleSmall,
                color = PizzaTheme.colorScheme.onBackground,
            )
            Text(
                text = pizza.description,
                style = PizzaTheme.typography.bodySmall,
                color = PizzaTheme.colorScheme.secondary,
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = {
                    if (quantity.value > 1)
                        viewModel.quantityChange(quantity.value - 1)
                }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                        contentDescription = "Decrease"
                    )
                }
                Text(
                    text = "${quantity.value}",
                    style = PizzaTheme.typography.titleSmall,
                )
                IconButton(
                    onClick = {
                        viewModel.quantityChange(quantity.value + 1)
                    }) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Increase"
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                IconButton(
                    onClick = {
                        viewModel.deleteFromCart(pizza)
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Delete"
                    )
                }
            }
        }
        Text(
            text = "${pizza.sizes.first().price * quantity.value} ₽",
            style = PizzaTheme.typography.titleSmall,
        )
    }
}