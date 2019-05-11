package com.yatochk.travelclock2.views

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.gms.maps.SupportMapFragment
import com.yatochk.travelclock2.R
import com.yatochk.travelclock2.dagger.components.DaggerAppComponent
import com.yatochk.travelclock2.model.TravelDatabase
import com.yatochk.travelclock2.model.TravelLocationManager
import com.yatochk.travelclock2.utils.LOCATION_PERMISSION_CODE
import com.yatochk.travelclock2.viewmodel.MainActivityViewModel


class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainActivityViewModel

    private lateinit var travelFragmentManager: TravelFragmentManager
    private lateinit var mapController: MapController
    private lateinit var travelLocationManager: TravelLocationManager
    private lateinit var travelDatabase: TravelDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerAppComponent.create().injectMainActivity(this)
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        travelFragmentManager = TravelFragmentManager(supportFragmentManager, R.id.frame)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync { googleMap ->
            mapController = MapController(googleMap, travelDatabase)
            mapController.setMoveListener { }
            travelLocationManager.locationLiveData.observe(
                this,
                Observer { position ->
                    mapController.changePosition(position)
                }
            )
        }

        viewModel.state.observe(
            this,
            Observer {
                when (it) {
                    MainState.Search -> {
                        travelFragmentManager.goTo(TravelFragments.SEARCH)
                    }

                    MainState.Select -> {
                        travelFragmentManager.goTo(TravelFragments.SELECT)
                    }

                    MainState.OnWay -> {
                        travelFragmentManager.goTo(TravelFragments.ON_WAY)
                    }

                    MainState.Alarm -> {
                        travelFragmentManager.goTo(TravelFragments.ALARM)
                    }

                    MainState.Settings -> {
                        travelFragmentManager.goTo(TravelFragments.SETTINGS)
                    }

                    else -> {
                        throw IllegalArgumentException("Wrong main state: ${it.name}")
                    }
                }
            }
        )
    }

    override fun onResume() {
        super.onResume()
        travelLocationManager.startListening().also {
            if (!it) {
                requestLocationPermission()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        travelLocationManager.stopListening()
    }

    private fun requestLocationPermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION),
            LOCATION_PERMISSION_CODE
        )
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == LOCATION_PERMISSION_CODE && grantResults.size == 2) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                travelLocationManager.startListening()
            } else {
                requestLocationPermission()
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}
