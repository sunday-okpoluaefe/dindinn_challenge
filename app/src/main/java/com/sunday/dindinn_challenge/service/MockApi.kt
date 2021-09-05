package com.sunday.dindinn_challenge.service

import co.infinum.retromock.meta.Mock
import co.infinum.retromock.meta.MockResponse
import com.sunday.dindinn_challenge.json.ordersResponse
import io.reactivex.rxjava3.core.Flowable
import retrofit2.Response
import retrofit2.http.GET
import rx.Observable


interface MockApi {

    @Mock
    @MockResponse(body = ordersResponse)
    @GET("/orders")
    fun getOrders(): Flowable<Response<OrdersResponse>>

    @Mock
    @MockResponse(body = ordersResponse)
    @GET("/ingredients")
    fun getIngredients(): Flowable<Response<OrdersResponse>>

    @Mock
    @MockResponse(body = ordersResponse)
    @GET("/ingredients")
    fun searchIngredients(): Flowable<Response<OrdersResponse>>
}