package com.daniil.feature_charger_list_impl.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.daniil.feature_charger_list_api.ChargerListArgument
import com.daniil.feature_charger_list_impl.presentation.mvi.ChargerListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class ChargerListFragment : Fragment() {

    private val viewModel by viewModel<ChargerListViewModel> {
        parametersOf(requireArguments().getParcelable<ChargerListArgument>(CHARGER_LIST_ARGUMENT))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                ChargerListScreen(
                    fragment = this@ChargerListFragment,
                    viewModel = viewModel,
                )
            }
        }
    }

    companion object {
        private const val CHARGER_LIST_ARGUMENT = "CHARGER_LIST_ARGUMENT"
        fun newInstance(argument: ChargerListArgument) = ChargerListFragment().apply {
            arguments = bundleOf(CHARGER_LIST_ARGUMENT to argument)
        }
    }
}