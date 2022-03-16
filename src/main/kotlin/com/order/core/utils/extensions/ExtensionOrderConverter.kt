package com.order.core.utils.extensions

import com.order.core.models.Order
import com.order.core.models.OrderJson

fun OrderJson.convertToOrder(): Order {

    return Order(
        orderId = this.orderId.getOrderId(),
        id = this.id,
        price = this.price,
        total = this.total,
        quantity = this.quantity,
        name = this.name,
        vendor = this.vendor,
        deliveryStart = this.deliveryStart,
        deliveryEnd = this.deliveryStart
    )
}

fun String.getOrderId(): Long {
    return this.substring(1).toLong()
}

