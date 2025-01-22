package com.daniil.data

import com.daniil.data.entity.ChargerResponse
import com.daniil.feature_charger_list_api.Charger

fun ChargerResponse.toDomain() = Charger(
    isBusy = charger.busy,
    name = charger.name,
    address = charger.address
)