package com.daniil.feature_choose_city_impl.presentation

import androidx.lifecycle.viewModelScope
import com.daniil.core.BaseViewModel
import com.daniil.feature_charger_list_api.ChargerListArgument
import com.daniil.feature_choose_city_api.ChooseCityInteractor
import com.daniil.feature_choose_city_impl.presentation.mvi.ChooseCityEvent
import com.daniil.feature_choose_city_impl.presentation.mvi.ChooseCitySideEffect
import com.daniil.feature_choose_city_impl.presentation.mvi.ChooseCityState
import kotlinx.coroutines.launch

class ChooseCityViewModel(private val interactor: ChooseCityInteractor) :
    BaseViewModel<ChooseCityState, ChooseCitySideEffect, ChooseCityEvent>(initialState = ChooseCityState()) {

    override fun dispatch(event: ChooseCityEvent) {
        when (event) {
            is ChooseCityEvent.OnCityClicked -> onCityClicked(event.city)
            ChooseCityEvent.OnConfirmClicked -> onConfirmClicked()
        }
    }

    init {
        init()
    }

    private fun init() {
        viewModelScope.launch {
            updateState { it.copy(isLoading = true) }
            val cities = interactor.getCities()
            updateState { it.copy(isLoading = false, cities = cities) }
        }
    }

    private fun onCityClicked(city: String) {
        viewModelScope.launch {
            updateState { it.copy(selectedCity = city) }
        }
    }

    private fun onConfirmClicked() {
        viewModelScope.launch {
            getState().selectedCity?.let { city ->
                postSideEffect(
                    ChooseCitySideEffect.ShowChargerList(
                        argument = ChargerListArgument(city = city)
                    )
                )
            }
        }
    }
}