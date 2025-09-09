package com.example.mobile_dev_assign_1

data class OrderSummary(
    val items: List<MenuItem>,
    val subtotal: Double,
    val gst: Double,
    val qst: Double,
    val total: Double
)