package com.sunday.dindinn_challenge.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Order(
    val addon: List<Addon>,
    @SerializedName("alerted_at")
    val alertedAt: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("expired_at")
    val expiredAt: String,
    val id: Int,
    val quantity: Int,
    val title: String
) : Parcelable