package com.sunday.dindinn_challenge.service

import com.sunday.dindinn_challenge.data.model.Order
import io.reactivex.rxjava3.core.Flowable
import rx.Observable

interface ApiClientType {
    fun getOrders(): Flowable<List<Order>>
    fun getIngredients(): Flowable<List<Order>>
}