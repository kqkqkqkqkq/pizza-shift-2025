package dev.k.ui_utils.mappers

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import dev.k.ui_utils.R

@Composable
fun getIngredientMap(s: String): String {
    return mapOf(
        "PINEAPPLE" to stringResource(R.string.pineapple),
        "MOZZARELLA" to stringResource(R.string.mozzarella),
        "PEPERONI" to stringResource(R.string.peperoni),
        "GREEN_PEPPER" to stringResource(R.string.green_pepper),
        "MUSHROOMS" to stringResource(R.string.mushrooms),
        "BASIL" to stringResource(R.string.basil),
        "CHEDDAR" to stringResource(R.string.cheddar),
        "PARMESAN" to stringResource(R.string.parmesan),
        "FETA" to stringResource(R.string.feta),
        "HAM" to stringResource(R.string.ham),
        "PICKLE" to stringResource(R.string.pickle),
        "TOMATO" to stringResource(R.string.tomato),
        "BACON" to stringResource(R.string.bacon),
        "ONION" to stringResource(R.string.onion),
        "CHILE" to stringResource(R.string.chile),
        "SHRIMPS" to stringResource(R.string.shrimps),
        "CHICKEN_FILLET" to stringResource(R.string.chicken_fillet),
        "MEATBALLS" to stringResource(R.string.meatballs),
    )[s].toString()
}

@Composable
fun getSizeMap(s: String): String {
    return mapOf(
        "LARGE" to stringResource(R.string.large),
        "MEDIUM" to stringResource(R.string.medium),
        "SMALL" to stringResource(R.string.small),
    )[s].toString()
}

@Composable
fun getDoughMap(s: String): String {
    return mapOf(
        "THIN" to stringResource(R.string.thin),
        "THICK" to stringResource(R.string.thick),
    )[s].toString()
}