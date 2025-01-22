package com.daniil.feature_charger_list_impl.presentation.mvi

sealed class ChargerListEvent {
    data object OnBackClicked : ChargerListEvent()
}