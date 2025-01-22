package com.daniil.data.repository

import com.daniil.data.server.ServerMock
import com.daniil.feature_choose_city_api.CatalogRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CatalogRepositoryImpl(private val serverApi: ServerMock) : CatalogRepository {
    override suspend fun getCities(): List<String> {
        return withContext(Dispatchers.IO) {
            serverApi.getCities()
        }
    }
}