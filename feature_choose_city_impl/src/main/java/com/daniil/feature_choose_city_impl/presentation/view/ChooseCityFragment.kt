package com.daniil.feature_choose_city_impl.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.daniil.feature_charger_list_api.ChargerListRouter
import com.daniil.feature_choose_city_impl.presentation.ChooseCityViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class ChooseCityFragment : Fragment() {

    private val viewModel by viewModel<ChooseCityViewModel>()
    private val chargerListRouter by inject<ChargerListRouter>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                ChooseCityScreen(
                    fragment = this@ChooseCityFragment,
                    viewModel = viewModel,
                    chargerListRouter = chargerListRouter
                )
            }
        }
    }
}