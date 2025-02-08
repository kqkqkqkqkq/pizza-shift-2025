package dev.k.ui_utils.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PizzaSizeUI(
    val name: String,
    val price: Int,
) : Parcelable