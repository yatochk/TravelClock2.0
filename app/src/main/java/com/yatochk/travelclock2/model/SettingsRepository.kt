package com.yatochk.travelclock2.model

import javax.inject.Inject

class SettingsRepository @Inject constructor(
    private val travelDatabase: TravelDatabase
) {
    fun updateSettings(settings: Settings) = travelDatabase.settingsDao.updateSettings(settings)

    fun insertSettings(settings: Settings) = travelDatabase.settingsDao.insertSettings(settings)

    fun getSettings() = travelDatabase.settingsDao.getSettings()
}