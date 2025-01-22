package com.daniil.feature_charger_list_impl.presentation.mvi

import com.daniil.feature_charger_list_api.Charger

data class ChargerListState(
    val isLoading: Boolean = false,
    val city: String,
    val chargerList: List<Charger> = listOf()
)