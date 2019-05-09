package com.yatochk.travelclock2.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DestinationDao {

    @Query("SELECT * FROM Destination")
    fun getDestinations(): List<Destination>

    @Query("SELECT * FROM Destination WHERE type = :destinationType")
    fun getDestination(destinationType: DestinationType): Destination

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveDestination(destination: Destination)

    @Query("DELETE FROM Destination WHERE type = :type")
    fun deleteDestination(type: DestinationType)
}