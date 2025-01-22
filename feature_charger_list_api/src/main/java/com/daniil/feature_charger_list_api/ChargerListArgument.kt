package com.daniil.feature_charger_list_api

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ChargerListArgument(
    val city: String
) : Parcelable