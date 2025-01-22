package com.daniil.feature_choose_city_api

interface ChooseCityInteractor {
    suspend fun getCities(): List<String>
}