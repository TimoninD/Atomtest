package com.daniil.atomtest

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.commit
import com.daniil.feature_choose_city_api.ChooseCityRouter
import org.koin.android.ext.android.inject
import com.daniil.uikit.R

class MainActivity : FragmentActivity(R.layout.activity_layout) {

    private val chooseCityRouter by inject<ChooseCityRouter>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                replace(R.id.content, chooseCityRouter.getChooseCity())
            }
        }
    }
}