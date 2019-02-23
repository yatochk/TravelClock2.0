package com.hhade.travelclock_20.views.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.hhade.travelclock_20.R
import com.hhade.travelclock_20.dagger.Components.DaggerAppComponent
import com.hhade.travelclock_20.viewmodel.MainActivityViewModel
import com.hhade.travelclock_20.views.MainState
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerAppComponent.create().injectMainActivity(this)

        viewModel.state.observe(
            this,
            Observer {
                when (it) {
                    MainState.Select -> {

                    }

                    MainState.OnWay -> {

                    }

                    MainState.Settings -> {

                    }

                    else -> {
                        throw IllegalArgumentException("Wrong main state: ${it.name}")
                    }
                }
            }
        )
    }
}
