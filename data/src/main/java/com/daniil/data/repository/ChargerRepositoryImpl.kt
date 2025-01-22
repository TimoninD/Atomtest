package com.daniil.data.repository

import com.daniil.data.server.ServerMock
import com.daniil.data.toDomain
import com.daniil.feature_charger_list_api.Charger
import com.daniil.feature_charger_list_api.ChargerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ChargerRepositoryImpl(private val serverApi: ServerMock) : ChargerRepository {

    override suspend fun getChargerList(): List<Charger> {
        return withContext(Dispatchers.IO) {
            serverApi.getChargerList().map {
                it.toDomain()
            }
        }
    }
}