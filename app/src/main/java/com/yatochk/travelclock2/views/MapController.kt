package com.yatochk.travelclock2.views

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.yatochk.travelclock2.model.TravelDatabase

class MapController(
    private val map: GoogleMap,
    private val travelDatabase: TravelDatabase
) {
    private var idleListener: (() -> Unit)? = null
    private val locationMarker = MarkerOptions().apply {
        draggable(false)
    }

    fun setMoveListener(listener: () -> Unit) {
        idleListener = listener
    }

    init {
        map.setOnCameraIdleListener { idleListener?.invoke() }
        map.addMarker(locationMarker)
    }

    fun changePosition(position: LatLng) {
        locationMarker.position(position)
        if (travelDatabase.settingsDao.getSettings().isFollow)
            moveToLocation(position)
    }

    private fun moveToLocation(location: LatLng) {
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(
                location,
                if (map.cameraPosition.zoom < 10) 10f else map.cameraPosition.zoom
            )
        )
    }
}