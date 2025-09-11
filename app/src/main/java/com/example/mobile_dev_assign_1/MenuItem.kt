package com.example.mobile_dev_assign_1

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf

data class MenuItem(
    val name: String,
    val description: String,
    val price: Double,
    val image: Int,
    var quantity: MutableState<Int> = mutableIntStateOf(0)
)
