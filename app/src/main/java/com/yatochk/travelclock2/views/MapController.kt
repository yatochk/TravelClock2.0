package com.yatochk.travelclock2.views

import com.google.android.gms.maps.GoogleMap

class MapController(map: GoogleMap) {
    private var idleListener: (() -> Unit)? = null
    fun setIdleListener(listener: () -> Unit) {
        idleListener = listener
    }

    init {
        map.setOnCameraIdleListener { idleListener?.invoke() }
    }
}