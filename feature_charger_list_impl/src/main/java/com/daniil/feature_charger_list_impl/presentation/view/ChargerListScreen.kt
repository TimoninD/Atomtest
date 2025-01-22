package com.daniil.feature_charger_list_impl.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.daniil.data.entity.ChargerData
import com.daniil.data.entity.ChargerResponse
import com.daniil.data.server.ServerMock
import com.daniil.feature_charger_list_api.Charger
import com.daniil.feature_charger_list_impl.presentation.mvi.ChargerListEvent
import com.daniil.feature_charger_list_impl.presentation.mvi.ChargerListSideEffect
import com.daniil.feature_charger_list_impl.presentation.mvi.ChargerListState
import com.daniil.feature_charger_list_impl.presentation.mvi.ChargerListViewModel
import com.daniil.uikit.components.ChargerItem
import com.daniil.uikit.components.TopBar
import com.daniil.uikit.R
import com.daniil.uikit.components.ContentLoading
import com.daniil.uikit.theme.Colors

@Composable
fun ChargerListScreen(
    viewModel: ChargerListViewModel,
    fragment: Fragment
) {
    val state by viewModel.collectAsState()

    ChargerListView(
        state = state,
        onEvent = { viewModel.dispatch(it) }
    )

    viewModel.collectSideEffect {
        handleSideEffect(effect = it, fragment = fragment)
    }
}

@Composable
private fun ChargerListView(
    state: ChargerListState,
    onEvent: (ChargerListEvent) -> Unit
) {
    ContentLoading(state.isLoading) {
        Scaffold(
            modifier = Modifier
                .background(Colors.onPrimary)
                .systemBarsPadding(),
            topBar = {
                TopBar(
                    text = stringResource(R.string.charger_list_title, state.city),
                    onBackClicked = { onEvent(ChargerListEvent.OnBackClicked) }
                )
            },
            content = {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(it),
                    contentPadding = PaddingValues(vertical = 16.dp)
                ) {
                    items(state.chargerList) {
                        ChargerItem(name = it.name, address = it.address, isBusy = it.isBusy)
                    }
                }
            }
        )
    }
}

private fun handleSideEffect(effect: ChargerListSideEffect, fragment: Fragment) {
    when (effect) {
        ChargerListSideEffect.GoBack -> fragment.requireActivity().supportFragmentManager.popBackStack()
    }
}

@Composable
@Preview
private fun ChargerListViewPreview() {
    ChargerListView(
        state = ChargerListState(
            city = "Москва",
            chargerList = listOf(
                Charger(
                    name = "Энергия Москвы",
                    isBusy = true,
                    address = "Измайловское ш., 4А"
                ),
                Charger(
                    name = "Lipgart",
                    isBusy = false,
                    address = "2-я Бауманская ул., 5, стр. 5"
                )
            )
        ), onEvent = {})
}