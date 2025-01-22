package com.daniil.feature_choose_city_api

interface CatalogRepository {
    suspend fun getCities(): List<String>
}