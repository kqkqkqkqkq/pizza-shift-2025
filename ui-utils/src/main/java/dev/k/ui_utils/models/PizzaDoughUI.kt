package dev.k.ui_utils.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PizzaDoughUI(
    val name: String,
    val price: Int,
    var isSelected: Boolean,
) : Parcelable