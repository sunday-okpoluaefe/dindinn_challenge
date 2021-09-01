package com.sunday.dindinn_challenge.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Addon(
    val id: Int,
    val quantity: Int,
    val title: String
) : Parcelable