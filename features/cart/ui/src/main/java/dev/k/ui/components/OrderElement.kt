package dev.k.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import dev.k.features.cart.ui.R
import dev.k.ui_kit.Destinations
import dev.k.ui_kit.theme.PizzaTheme

@Composable
fun OrderElement(
    cost: Int,
    navController: NavHostController,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(128.dp),
        colors = CardDefaults.cardColors(
            containerColor = PizzaTheme.colorScheme.background,
        ),
        shape = RoundedCornerShape(
            topStart = 16.dp,
            topEnd = 16.dp,
            bottomStart = 0.dp,
            bottomEnd = 0.dp,
        ),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 8.dp,
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .height(42.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = stringResource(R.string.order_cost),
                    color = PizzaTheme.colorScheme.onBackground,
                    style = PizzaTheme.typography.titleSmall,
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "${cost} ₽",
                    color = PizzaTheme.colorScheme.onBackground,
                    style = PizzaTheme.typography.titleSmall,
                )
            }
            TextButton(
                modifier = Modifier
                    .fillMaxWidth(0.75f),
                onClick = {
                    navController.navigate(Destinations.MAKE_ORDER_USER_DATA_SCREEN)
                },
                colors = ButtonDefaults.textButtonColors(
                    containerColor = PizzaTheme.colorScheme.primary,
                )
            ) {
                Text(
                    text = stringResource(R.string.make_order),
                    color = PizzaTheme.colorScheme.onPrimary,
                    style = PizzaTheme.typography.titleSmall,
                )
            }
        }
    }
}