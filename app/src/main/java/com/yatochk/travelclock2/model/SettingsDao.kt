package com.yatochk.travelclock2.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface SettingsDao {

    @Query("SELECT * FROM Settings")
    fun getSettings(): Settings

    @Insert
    fun insertSettings(settings: Settings)

    @Update
    fun updateSettings(settings: Settings)
}