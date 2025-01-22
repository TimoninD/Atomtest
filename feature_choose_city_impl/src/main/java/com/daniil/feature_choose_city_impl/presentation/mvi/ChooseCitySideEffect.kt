package com.daniil.feature_choose_city_impl.presentation.mvi

import com.daniil.feature_charger_list_api.ChargerListArgument

sealed class ChooseCitySideEffect {
    data class ShowChargerList(val argument: ChargerListArgument) : ChooseCitySideEffect()
}