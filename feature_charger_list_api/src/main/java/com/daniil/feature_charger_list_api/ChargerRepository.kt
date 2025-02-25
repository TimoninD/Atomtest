package com.daniil.feature_charger_list_api

interface ChargerRepository {
    suspend fun getChargerList(city: String): List<Charger>
}