package com.order.core.models

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.core.annotation.Introspected
import java.util.Date

@Introspected
data class OrderJson(

    @JsonProperty("Order #")
    var orderId: String = "",

    @JsonProperty("id")
    var id: String = "",

    @JsonProperty("Price")
    var price: Double = 0.0,

    @JsonProperty("Total.")
    var total: Double = 0.0,

    @JsonProperty("Quantity")
    var quantity: Int = 0,

    @JsonProperty("Name")
    var name: String = "",

    @JsonProperty("Vendor (from Vendor)")
    var vendor: String = "",

    @JsonProperty("Delivery Start (from Order)")
    @JsonFormat(pattern = "yyyy-MM-dd")
    var deliveryStart: Date? = null,

    @JsonProperty("Delivery End (from Order)")
    @JsonFormat(pattern = "yyyy-MM-dd")
    var deliveryEnd: Date? = null
)