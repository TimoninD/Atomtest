package com.daniil.data

import com.daniil.data.repository.CatalogRepositoryImpl
import com.daniil.data.repository.ChargerRepositoryImpl
import com.daniil.data.server.ServerMock
import com.daniil.feature_charger_list_api.ChargerRepository
import com.daniil.feature_choose_city_api.CatalogRepository
import org.koin.dsl.module

class DataModule {

    val module = module {

        single<ServerMock> { ServerMock() }

        single<CatalogRepository> {
            CatalogRepositoryImpl(serverApi = get())
        }

        single<ChargerRepository> {
            ChargerRepositoryImpl(serverApi = get())
        }
    }
}