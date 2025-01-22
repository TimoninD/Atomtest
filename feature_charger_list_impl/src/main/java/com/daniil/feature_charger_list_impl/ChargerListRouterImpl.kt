package com.daniil.feature_charger_list_impl

import androidx.fragment.app.Fragment
import com.daniil.feature_charger_list_api.ChargerListRouter
import com.daniil.feature_charger_list_impl.presentation.ChargerListFragment

class ChargerListRouterImpl: ChargerListRouter {
    override fun getChargerList(): Fragment {
        return ChargerListFragment()
    }
}