package com.daniil.data.server

import com.daniil.data.entity.ChargerData
import com.daniil.data.entity.ChargerResponse
import kotlinx.coroutines.delay

class ServerMock {

    suspend fun getCities(): List<String> {
        delay(1_000)
        return listOf("Moscow", "Saint Petersburg")
    }

    suspend fun getChargerList(): List<ChargerResponse> {
        delay(1_000)
        return listOf(
            ChargerResponse(
                city = "Moscow",
                charger = ChargerData(
                    name = "Энергия Москвы",
                    busy = true,
                    address = "Измайловское ш., 4А"
                )
            ),
            ChargerResponse(
                city = "Moscow",
                charger = ChargerData(
                    name = "Lipgart",
                    busy = false,
                    address = "2-я Бауманская ул., 5, стр. 5"
                )
            ),
            ChargerResponse(
                city = "Saint Petersburg",
                charger = ChargerData(
                    name = "Станция зарядки электромобилей",
                    busy = true,
                    address = "Большой просп. Васильевского острова, 68"
                )
            ),
            ChargerResponse(
                city = "Moscow",
                charger = ChargerData(
                    name = "Zevs",
                    busy = false,
                    address = "Мясницкая ул., 13, стр. 10"
                )
            ),
            ChargerResponse(
                city = "Saint Petersburg",
                charger = ChargerData(
                    name = "Punkt E",
                    busy = false,
                    address = "Малая Монетная ул., 2Г"
                )
            )
        )
    }
}