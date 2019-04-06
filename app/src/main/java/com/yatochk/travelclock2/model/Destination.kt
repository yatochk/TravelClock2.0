package com.yatochk.travelclock2.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.android.gms.maps.model.LatLng

@Entity
data class Destination(
    @PrimaryKey
    val type: DestinationType,
    val coordination: LatLng
)

enum class DestinationType {
    CURRENT,
    LAST
}