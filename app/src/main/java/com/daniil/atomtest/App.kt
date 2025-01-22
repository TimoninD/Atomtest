package com.daniil.atomtest

import android.app.Application
import com.daniil.data.DataModule
import com.daniil.feature_charger_list_impl.ChargerListModule
import com.daniil.feature_choose_city_impl.ChooseCityModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    private val modules = listOf(
        DataModule().module,
        ChooseCityModule().module,
        ChargerListModule().module
    )

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(applicationContext)
            modules(modules)
        }
    }
}