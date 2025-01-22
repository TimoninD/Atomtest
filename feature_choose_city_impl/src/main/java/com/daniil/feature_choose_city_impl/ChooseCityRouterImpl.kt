package com.daniil.feature_choose_city_impl

import androidx.fragment.app.Fragment
import com.daniil.feature_choose_city_api.ChooseCityRouter
import com.daniil.feature_choose_city_impl.presentation.view.ChooseCityFragment

class ChooseCityRouterImpl : ChooseCityRouter {
    override fun getChooseCity(): Fragment {
        return ChooseCityFragment.newInstance()
    }
}