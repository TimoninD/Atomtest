package com.daniil.feature_choose_city_impl

import com.daniil.feature_choose_city_api.ChooseCityInteractor
import com.daniil.feature_choose_city_api.ChooseCityRouter
import com.daniil.feature_choose_city_impl.domain.ChooseCityInteractorImpl
import com.daniil.feature_choose_city_impl.presentation.ChooseCityViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

class ChooseCityModule {

    val module = module {
        viewModel {
            ChooseCityViewModel(interactor = get())
        }

        factory<ChooseCityInteractor> {
            ChooseCityInteractorImpl(catalogRepository = get())
        }
        factory<ChooseCityRouter> {
            ChooseCityRouterImpl()
        }
    }
}