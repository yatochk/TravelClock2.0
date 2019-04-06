package com.yatochk.travelclock2.model

import javax.inject.Inject

class DestinationRepository @Inject constructor(
    private val travelDatabase: TravelDatabase
) {
    fun save(destination: Destination) = travelDatabase.destinationDao.saveDestination(destination)

    fun getDestinations() = travelDatabase.destinationDao.getDestinations()

    fun getDestinations(destinationType: DestinationType) =
        travelDatabase.destinationDao.getDestination(destinationType)

    fun delete(destinationType: DestinationType) = travelDatabase.destinationDao.deleteDestination(destinationType)

}