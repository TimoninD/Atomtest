package com.daniil.feature_charger_list_impl.presentation.mvi

sealed class ChargerListSideEffect {

    data object GoBack : ChargerListSideEffect()
}