package com.daniil.feature_choose_city_impl.presentation.mvi

data class ChooseCityState(
    val isLoading: Boolean = false,
    val selectedCity: String? = null,
    val cities: List<String> = listOf()
)