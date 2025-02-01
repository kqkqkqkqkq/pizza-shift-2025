package dev.k.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class PizzaDoughUI(
    val name: String,
    val price: Int,
): Parcelable