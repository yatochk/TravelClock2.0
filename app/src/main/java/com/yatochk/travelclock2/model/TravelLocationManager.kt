package com.yatochk.travelclock2.model

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Context.LOCATION_SERVICE
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.maps.model.LatLng
import javax.inject.Inject


class TravelLocationManager @Inject constructor(private val context: Context) {
    private val locationListener: LocationListener = object : LocationListener {
        override fun onLocationChanged(location: Location) {
            locationMutableLiveData.value = LatLng(location.latitude, location.longitude)
        }

        override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {

        }

        override fun onProviderEnabled(provider: String?) {

        }

        override fun onProviderDisabled(provider: String?) {

        }
    }

    private var locationManager: LocationManager =
        (context.getSystemService(LOCATION_SERVICE) as LocationManager)

    private val locationMutableLiveData = MutableLiveData<LatLng>()
    @SuppressLint("MissingPermission")
    private fun setLocationListener() {
        locationManager.requestLocationUpdates(
            LocationManager.GPS_PROVIDER,
            1000 * 10, 10f, locationListener
        )
        locationManager.requestLocationUpdates(
            LocationManager.NETWORK_PROVIDER, 1000 * 10, 10f,
            locationListener
        )
    }

    private fun checkLocationPermission(): Boolean =
        ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.READ_EXTERNAL_STORAGE
        ) == PackageManager.PERMISSION_GRANTED

    val locationLiveData: LiveData<LatLng> = locationMutableLiveData

    fun startListening(): Boolean =
        checkLocationPermission().also {
            if (it)
                setLocationListener()
        }

    fun stopListening() {
        locationManager.removeUpdates(locationListener)
    }
}
