package com.example.allttaemerona.src.main.purchaser.list.models

import android.net.Uri

data class RequestItem(
    var image: String,
    val address: String,
    var time: Int,
    val deliveryPay: Int,
    val product: String
)
