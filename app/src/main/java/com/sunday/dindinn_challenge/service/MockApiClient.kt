package com.sunday.dindinn_challenge.service

import com.sunday.dindinn_challenge.data.model.Order
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject

class MockApiClient @Inject constructor(val api: MockApi) : ApiClientType {

    override fun getOrders(): Flowable<List<Order>> = api.getOrders()
        .map { it.body()?.data }

    override fun getIngredients(): Flowable<List<Order>> {
        TODO("Not yet implemented")
    }
}
