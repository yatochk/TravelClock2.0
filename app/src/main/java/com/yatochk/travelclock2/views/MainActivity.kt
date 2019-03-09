package com.yatochk.travelclock2.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.gms.maps.SupportMapFragment
import com.yatochk.travelclock2.R
import com.yatochk.travelclock2.dagger.Components.DaggerAppComponent
import com.yatochk.travelclock2.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainActivityViewModel

    private lateinit var travelFragmentManager: TravelFragmentManager
    private lateinit var mapController: MapController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerAppComponent.create().injectMainActivity(this)
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        travelFragmentManager = TravelFragmentManager(supportFragmentManager, R.id.frame)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync {
            mapController = MapController(it)
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
}
