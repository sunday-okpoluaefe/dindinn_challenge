package com.sunday.dindinn_challenge.service

import android.os.Parcelable
import com.sunday.dindinn_challenge.data.model.Order
import kotlinx.android.parcel.Parcelize

@Parcelize
data class OrdersResponse (val status: Status, val data: List<Order>) : Parcelable

@Parcelize
data class Status(val success: Boolean, val statusCode: Int, val message: String) : Parcelable