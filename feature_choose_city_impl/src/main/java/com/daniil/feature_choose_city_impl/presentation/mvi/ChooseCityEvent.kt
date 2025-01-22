package com.daniil.feature_choose_city_impl.presentation.mvi

sealed class ChooseCityEvent {

    data class OnCityClicked(val city: String) : ChooseCityEvent()
    data object OnConfirmClicked : ChooseCityEvent()
}