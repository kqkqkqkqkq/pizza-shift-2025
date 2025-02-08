package dev.k.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import dev.k.ui_kit.Destinations
import dev.k.ui_kit.theme.PizzaTheme
import dev.k.ui_utils.models.PizzaUI

@Composable
fun PizzaItemUI(
    pizza: PizzaUI,
    navController: NavHostController,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(128.dp)
            .clickable {
                navController.currentBackStackEntry?.savedStateHandle?.set("pizzaUI", pizza)
                navController.navigate(Destinations.PIZZA_DETAIL_SCREEN)
            },
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        AsyncImage(
            modifier = Modifier
                .padding(start = 16.dp, bottom = 12.dp)
                .size(116.dp),
            model = pizza.img,
            contentDescription = "Pizza image"
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top,
        ) {
            Text(
                text = pizza.name,
                color = PizzaTheme.colorScheme.onBackground,
                style = PizzaTheme.typography.titleSmall,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = pizza.description,
                color = PizzaTheme.colorScheme.onBackground.copy(alpha = 0.75f),
                style = PizzaTheme.typography.bodySmall,
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "От ${pizza.sizes.first().price} ₽",
                color = PizzaTheme.colorScheme.onBackground,
                style = PizzaTheme.typography.titleSmall,
            )
        }
    }
}