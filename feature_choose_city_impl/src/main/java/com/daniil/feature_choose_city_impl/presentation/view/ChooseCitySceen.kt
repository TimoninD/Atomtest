package com.daniil.feature_choose_city_impl.presentation.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.daniil.feature_charger_list_api.ChargerListRouter
import com.daniil.uikit.R
import com.daniil.feature_choose_city_impl.presentation.ChooseCityViewModel
import com.daniil.feature_choose_city_impl.presentation.mvi.ChooseCityEvent
import com.daniil.feature_choose_city_impl.presentation.mvi.ChooseCitySideEffect
import com.daniil.feature_choose_city_impl.presentation.mvi.ChooseCityState
import com.daniil.uikit.components.CityItem
import com.daniil.uikit.components.PrimaryButton
import com.daniil.uikit.theme.Colors
import com.daniil.uikit.theme.Font

@Composable
fun ChooseCityScreen(
    fragment: Fragment,
    viewModel: ChooseCityViewModel,
    chargerListRouter: ChargerListRouter
) {

    val state by viewModel.collectAsState()

    ChooseCityView(state = state, onEvent = { viewModel.dispatch(it) })

    viewModel.collectSideEffect {
        handleSideEffect(
            effect = it,
            fragment = fragment,
            chargerListRouter = chargerListRouter
        )
    }
}

@Composable
private fun ChooseCityView(state: ChooseCityState, onEvent: (ChooseCityEvent) -> Unit) {
    Scaffold(
        modifier = Modifier.systemBarsPadding(),
        topBar = {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = stringResource(R.string.choose_city_title),
                    style = Font.headline1(Colors.onSurface)
                )
            }
        },
        bottomBar = {
            PrimaryButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 14.dp),
                onClick = { onEvent(ChooseCityEvent.OnConfirmClicked) },
                text = stringResource(R.string.choose_city_confirm)
            )
        },
        content = {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
                contentPadding = PaddingValues(vertical = 16.dp)
            ) {
                items(state.cities) {
                    CityItem(
                        city = it,
                        selected = state.selectedCity == it,
                        onClick = { onEvent(ChooseCityEvent.OnCityClicked(it)) }
                    )
                }
            }
        }
    )
}

private fun handleSideEffect(
    effect: ChooseCitySideEffect,
    fragment: Fragment,
    chargerListRouter: ChargerListRouter
) {
    when (effect) {
        is ChooseCitySideEffect.ShowChargerList -> fragment.requireActivity()
            .supportFragmentManager
            .commit {
                replace(
                    R.id.content,
                    chargerListRouter.getChargerList()
                )
            }
    }
}

@Composable
@Preview
private fun ChooseCityViewPreview() {
    ChooseCityView(
        state = ChooseCityState(
            cities = listOf("Moscow", "Volgograd"),
            selectedCity = "Volgograd"
        ),
        onEvent = {}
    )
}