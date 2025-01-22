package com.daniil.feature_charger_list_impl.domain

import com.daniil.feature_charger_list_api.Charger
import com.daniil.feature_charger_list_api.ChargerListInteractor
import com.daniil.feature_charger_list_api.ChargerRepository

class ChargerListInteractorImpl(
    private val chargerRepository: ChargerRepository
) : ChargerListInteractor {
    override suspend fun getChargerList(city: String): List<Charger> {
        return chargerRepository.getChargerList(city)
    }
}