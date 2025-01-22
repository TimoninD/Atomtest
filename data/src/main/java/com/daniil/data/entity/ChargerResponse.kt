package com.daniil.data.entity

data class ChargerResponse(
    val charger: ChargerData,
    val city: String
)

data class ChargerData(
    val address: String,
    val name: String,
    val busy: Boolean
)