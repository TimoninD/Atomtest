package com.daniil.feature_charger_list_impl

import com.daniil.feature_charger_list_api.ChargerListRouter
import org.koin.dsl.module

class ChargerListModule {

    val module = module {
        factory<ChargerListRouter> {
            ChargerListRouterImpl()
        }
    }
}