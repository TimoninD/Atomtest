package com.daniil.feature_choose_city_impl.domain

import com.daniil.feature_choose_city_api.CatalogRepository
import com.daniil.feature_choose_city_api.ChooseCityInteractor

class ChooseCityInteractorImpl(private val catalogRepository: CatalogRepository) :
    ChooseCityInteractor {
    override suspend fun getCities(): List<String> {
        return catalogRepository.getCities()
    }
}