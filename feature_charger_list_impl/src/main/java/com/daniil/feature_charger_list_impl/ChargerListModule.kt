package com.daniil.feature_charger_list_impl

import com.daniil.feature_charger_list_api.ChargerListArgument
import com.daniil.feature_charger_list_api.ChargerListInteractor
import com.daniil.feature_charger_list_api.ChargerListRouter
import com.daniil.feature_charger_list_impl.domain.ChargerListInteractorImpl
import com.daniil.feature_charger_list_impl.presentation.mvi.ChargerListViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

class ChargerListModule {

    val module = module {
        factory<ChargerListRouter> {
            ChargerListRouterImpl()
        }
        factory<ChargerListInteractor> {
            ChargerListInteractorImpl(chargerRepository = get())
        }

        viewModel { (argument: ChargerListArgument) ->
            ChargerListViewModel(
                argument = argument,
                interactor = get()
            )
        }
    }
}