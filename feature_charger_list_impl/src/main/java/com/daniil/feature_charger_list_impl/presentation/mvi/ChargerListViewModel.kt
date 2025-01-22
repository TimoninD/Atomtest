package com.daniil.feature_charger_list_impl.presentation.mvi

import androidx.lifecycle.viewModelScope
import com.daniil.core.BaseViewModel
import com.daniil.feature_charger_list_api.ChargerListArgument
import com.daniil.feature_charger_list_api.ChargerListInteractor
import kotlinx.coroutines.launch

class ChargerListViewModel(
    private val interactor: ChargerListInteractor,
    private val argument: ChargerListArgument
) :
    BaseViewModel<ChargerListState, ChargerListSideEffect, ChargerListEvent>(
        initialState = ChargerListState(city = argument.city)
    ) {

    init {
        init()
    }

    private fun init() {
        viewModelScope.launch {
            updateState { it.copy(isLoading = true) }
            val chargerList = interactor.getChargerList(city = getState().city)
            updateState { it.copy(isLoading = false, chargerList = chargerList) }
        }
    }

    override fun dispatch(event: ChargerListEvent) {
        when (event) {
            ChargerListEvent.OnBackClicked -> onBackClicked()
        }
    }

    private fun onBackClicked() {
        viewModelScope.launch {
            postSideEffect(ChargerListSideEffect.GoBack)
        }
    }
}