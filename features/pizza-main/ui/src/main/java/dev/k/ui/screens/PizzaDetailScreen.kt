package dev.k.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import dev.k.domain.models.PizzaIngredientUI
import dev.k.domain.models.PizzaSizeUI
import dev.k.domain.models.PizzaUI
import dev.k.ui.components.Header
import dev.k.ui.navigation.Screen
import dev.k.ui_kit.OrangeLight

@Composable
fun PizzaDetailScreen(
    pizza: PizzaUI,
    navController: NavHostController,
) {
//    val viewModel: PizzaDetailVewModel = hiltViewModel()
    PizzaDetailScreenUI(pizza, navController)
}

@Composable
internal fun PizzaDetailScreenUI(
    pizza: PizzaUI,
//    viewModel: PizzaDetailVewModel,
    navController: NavHostController,
) {
    var selectedSize by remember { mutableStateOf(0) }
    val pizzaSizesList = pizza.sizes

    Scaffold(
        topBar = {
            Header("Пицца") {
                navController.navigate(Screen.Pizza.route) {
                    popUpTo(Screen.PIZZA_DETAIL) {
                        inclusive = true
                    }
                }
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = 12.dp,
                    top = padding.calculateTopPadding() + 12.dp,
                    end = 12.dp,
                    bottom = padding.calculateBottomPadding(),
                ),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
                    .padding(top = 12.dp),
                contentAlignment = Alignment.Center,
            ) {
                // TODO("Вынести url в константу")
                AsyncImage(
                    modifier = Modifier.size(220.dp),
                    model = "https://shift-intensive.ru/api${pizza.img}",
                    contentDescription = "pizza detail image"
                )
            }
            Text(
                text = pizza.name,
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
            )
//          TODO("сделать функицю получения строчки")
            Text(
                text = "${pizza.sizes.first().name} ${pizza.doughs.first().name} тесто",
                color = Color.Black.copy(alpha = 0.6f),
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
            )
            Text(
                text = pizza.description,
                color = Color.Black.copy(alpha = 0.6f),
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
            )
            PizzaSizeSelector(
                sizes = pizzaSizesList,
                selectedIndex = selectedSize,
                onOptionSelected = { selectedSize = it }
            )
            Text(
                text = "Добавить по вкусу",
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
            )
            AdditivesGrid(pizza.toppings)
        }
    }
}

@Composable
fun PizzaSizeSelector(
    sizes: List<PizzaSizeUI>,
    selectedIndex: Int,
    onOptionSelected: (Int) -> Unit
) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .background(Color(0xFFF5F6F7), shape = RoundedCornerShape(20.dp))
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
                Text(
                    text = size.name,
                    color = if (isSelected) Color.Black else Color.Gray,
                    fontWeight = FontWeight.Normal
                )
            }
        }
    }
}

@Composable
fun AdditiveItem(
    name: String,
    price: String,
    image: String,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    Card(
        modifier = Modifier
            .size(width = 104.dp, height = 172.dp)
            .clickable { onClick() }
            .border(
                width = 4.dp,
                color = if (isSelected) OrangeLight.copy(alpha = 0.5f) else Color.Transparent,
                shape = RoundedCornerShape(12.dp)
            ),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center,
            ) {
                //TODO("Вынести url")
                AsyncImage(
                    model = "https://shift-intensive.ru/api$image",
                    contentDescription = "addition",
                    modifier = Modifier.size(64.dp),
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = name, fontSize = 14.sp, textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "$price ₽", fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun AdditivesGrid(
    additives: List<PizzaIngredientUI>,
) {
    var selectedItems by remember { mutableStateOf(setOf<String>()) }

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
                        selectedItems = if (isSelected) {
                            selectedItems - item.name
                        } else {
                            selectedItems + item.name
                        }
                    }
                )
            }
        }
    }
}