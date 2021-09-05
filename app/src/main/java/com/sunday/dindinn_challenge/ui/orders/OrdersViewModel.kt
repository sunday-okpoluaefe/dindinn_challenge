package com.sunday.dindinn_challenge.ui.orders

import androidx.lifecycle.*
import com.sunday.dindinn_challenge.data.model.Order
import com.sunday.dindinn_challenge.service.ApiClientType
import io.reactivex.rxjava3.schedulers.Schedulers

import javax.inject.Inject

class OrdersViewModel @Inject constructor(private val apiClientType: ApiClientType) : ViewModel() {

    private var _orders = MediatorLiveData<List<Order>>()
    val orders: LiveData<List<Order>> = _orders

    private var _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    init {

        getOrders()
    }

    fun getOrders() {
        val source: LiveData<List<Order>> = LiveDataReactiveStreams.fromPublisher(apiClientType.getOrders().subscribeOn(Schedulers.io()))
        _orders.addSource(source, Observer {
            _orders.value = it
            _orders.removeSource(source)
        })
    }

}