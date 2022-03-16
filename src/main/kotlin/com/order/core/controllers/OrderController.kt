package com.order.core.controllers

import com.order.core.models.Order
import com.order.core.services.OrderService
import com.order.core.utils.constants.Routes.ORDER
import com.order.core.utils.constants.Routes.ORDER_GET_ORDERS
import com.order.core.utils.constants.Routes.ORDER_GET_ORDERS_BY_VENDOR
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.reactivex.rxjava3.core.Single

@Controller(ORDER)
class OrderController(
    private val orderService: OrderService
) {

    @Get(ORDER_GET_ORDERS)
    fun getAllOrders(): Single<List<Order>> {

        return orderService.getAllOrders()
    }

    @Get(ORDER_GET_ORDERS_BY_VENDOR)
    fun getOrdersByVendor(): Single<Map<String, List<Order>>> {

        return orderService.getOrdersByVendor()
    }
}