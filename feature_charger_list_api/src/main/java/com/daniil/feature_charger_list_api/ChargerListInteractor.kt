package com.daniil.feature_charger_list_api

interface ChargerListInteractor {
    suspend fun getChargerList(city: String): List<Charger>
}