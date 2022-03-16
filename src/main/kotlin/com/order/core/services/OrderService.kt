package com.order.core.services

import com.fasterxml.jackson.databind.ObjectMapper
import com.order.core.models.Order
import com.order.core.models.OrderJson
import com.order.core.utils.extensions.convertToOrder
import io.reactivex.rxjava3.core.Single
import jakarta.inject.Singleton
import java.nio.file.Files
import java.nio.file.Paths


@Singleton
open class OrderService(
    private val objectMapper: ObjectMapper
) {

    open fun getAllOrders(): Single<List<Order>> {
        val jsonMessage = String(Files.readAllBytes(Paths.get("src/main/resources/json/EL.json")))
        val listType = objectMapper.typeFactory.constructCollectionType(ArrayList::class.java, OrderJson::class.java)

        val orderJsons = objectMapper.readValue<List<OrderJson>>(jsonMessage, listType).map { it.convertToOrder() }

        return Single.just(orderJsons)
    }

    open fun getOrdersByVendor(): Single<Map<String, List<Order>>> {
        return getAllOrders().map { orders ->
            orders.groupBy { o -> o.vendor }
        }
    }
}