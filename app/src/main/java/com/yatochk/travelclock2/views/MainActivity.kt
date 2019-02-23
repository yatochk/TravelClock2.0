package com.yatochk.travelclock2.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.yatochk.travelclock2.R
import com.yatochk.travelclock2.dagger.Components.DaggerAppComponent
import com.yatochk.travelclock2.viewmodel.MainActivityViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MainActivityViewModel

    private val searchFragment = SearchFragment()
    private val selectFragment = SelectFragment()
    private val onWayFragment = OnWayFragment()
    private val alarmFragment = AlarmFragment()
    private val settingFragment = SettingsFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerAppComponent.create().injectMainActivity(this)

        viewModel.state.observe(
            this,
            Observer {
                when (it) {
                    MainState.Search -> {
                        goToFragment(searchFragment, getString(R.string.titleSearch))
                    }

                    MainState.Select -> {
                        goToFragment(selectFragment, getString(R.string.titleSelect))
                    }

                    MainState.OnWay -> {
                        goToFragment(onWayFragment, getString(R.string.titleOnWay))
                    }

                    MainState.Alarm -> {
                        goToFragment(alarmFragment, getString(R.string.titleAlarm))
                    }

                    MainState.Settings -> {
                        goToFragment(settingFragment, getString(R.string.titleSettings))
                    }

                    else -> {
                        throw IllegalArgumentException("Wrong main state: ${it.name}")
                    }
                }
            }
        )
    }

    private fun goToFragment(fragment: Fragment, name: String) {
        supportFragmentManager.beginTransaction()
            .addToBackStack(name)
            .replace(R.id.frame, fragment)
    }
}
