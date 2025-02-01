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
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import coil.compose.AsyncImage
import dev.k.ui_logic.models.PizzaUI

@Composable
fun CartItem(
    pizza: PizzaUI,
    quantity: Int = 1,
//    onQuantityChange: (Int) -> Unit,
//    onEditClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = pizza.img,
            contentDescription = "cart",
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(text = pizza.name, fontWeight = FontWeight.Medium, fontSize = 16.sp)
            Text(text = pizza.description, fontSize = 12.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(4.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = { }){//if (quantity > 1) onQuantityChange(quantity - 1) }) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = "Decrease")
                }
                Text(text = "$quantity", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                IconButton(onClick = { }){//onQuantityChange(quantity + 1) }) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Increase")
                }
                Spacer(modifier = Modifier.width(8.dp))
                TextButton(onClick = {}){//onEditClick) {
                    Text(text = "Изменить", color = Color.Blue)
                }
            }
        }

        Text(text = "${pizza.sizes.first().price} ₽", fontWeight = FontWeight.Bold, fontSize = 16.sp)
    }
}