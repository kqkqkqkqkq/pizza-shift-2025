package dev.k.ui_utils.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PizzaIngredientUI(
    val name: String,
    val cost: Int,
    val img: String,
) : Parcelable