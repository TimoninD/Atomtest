package com.daniil.feature_charger_list_api

import androidx.fragment.app.Fragment

interface ChargerListRouter {
    fun getChargerList(argument: ChargerListArgument): Fragment
}