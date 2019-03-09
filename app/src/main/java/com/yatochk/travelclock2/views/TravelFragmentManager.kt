package com.yatochk.travelclock2.views

import androidx.annotation.IdRes
import androidx.fragment.app.FragmentManager

class TravelFragmentManager(private val fragmentManager: FragmentManager, @IdRes private val containerViewId: Int) {

    private val searchFragment = SearchFragment()
    private val selectFragment = SelectFragment()
    private val onWayFragment = OnWayFragment()
    private val alarmFragment = AlarmFragment()
    private val settingFragment = SettingsFragment()

    init {
        fragmentManager.beginTransaction()
            .add(containerViewId, settingFragment, TravelFragments.SETTINGS.name)
            .hide(settingFragment)
            .add(containerViewId, alarmFragment, TravelFragments.ALARM.name)
            .hide(alarmFragment)
            .add(containerViewId, onWayFragment, TravelFragments.ON_WAY.name)
            .hide(onWayFragment)
            .add(containerViewId, selectFragment, TravelFragments.SELECT.name)
            .hide(selectFragment)
            .add(containerViewId, searchFragment, TravelFragments.SEARCH.name)
            .commit()
    }

    private var oldFragment: BaseFragment = searchFragment
    fun goTo(name: TravelFragments) {
        val fragment: BaseFragment = when (name) {
            TravelFragments.SEARCH -> searchFragment
            TravelFragments.ON_WAY -> onWayFragment
            TravelFragments.SELECT -> selectFragment
            TravelFragments.ALARM -> alarmFragment
            TravelFragments.SETTINGS -> settingFragment
        }

        fragmentManager.beginTransaction()
            .addToBackStack(name.name)
            .hide(oldFragment)
            .show(fragment)
            .commit()

        oldFragment = fragment
    }
}