package com.example.mobile_dev_assign_1

data class MenuItem(
    val name: String,
    val description: String,
    val price: Double,
    val image: Int,
    var quantity: Int = 0
)
