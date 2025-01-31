package dev.k.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import dev.k.domain.models.PizzaUI


@Composable
fun PizzaItemUI(
    pizza: PizzaUI,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(130.dp),
    ) {
        TODO("Верстка")
//        AsyncImage(
//            model = pizza.img,
//            contentDescription = "pizza-image"
//        )
//        Spacer(modifier = Modifier.weight(1f))
        Column {
            Text(pizza.name)
        }
    }
}