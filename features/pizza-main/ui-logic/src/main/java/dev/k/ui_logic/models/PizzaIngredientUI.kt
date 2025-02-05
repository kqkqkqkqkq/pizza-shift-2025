package dev.k.ui_logic.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PizzaIngredientUI(
    val name: String,
    val cost: Int,
    val img: String
) : Parcelable