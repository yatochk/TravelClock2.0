package com.yatochk.travelclock2.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        Settings::class,
        Destination::class
    ],
    version = 1
)
abstract class TravelDatabase : RoomDatabase() {
    abstract val settingsDao: SettingsDao
    abstract val destinationDao: DestinationDao
}