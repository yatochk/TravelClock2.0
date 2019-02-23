package com.yatochk.travelclock2.views.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.yatochk.travelclock2.R
import com.yatochk.travelclock2.dagger.Components.DaggerAppComponent
import com.yatochk.travelclock2.viewmodel.MainActivityViewModel
import com.yatochk.travelclock2.views.MainState
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
