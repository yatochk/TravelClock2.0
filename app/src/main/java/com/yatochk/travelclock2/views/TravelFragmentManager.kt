package com.yatochk.travelclock2.views

import androidx.annotation.IdRes
import androidx.fragment.app.FragmentManager

class TravelFragmentManager(private val fragmentManager: FragmentManager, @IdRes private val containerViewId: Int) {

    private val searchFragment = SearchFragment()
    private val selectFragment = SelectFragment()
    private val onWayFragment = OnWayFragment()
    private val alarmFragment = AlarmFragment()
    private val settingFragment = SettingsFragment()

    private fun setCurrentFragment(fragment: BaseFragment) {
        fragmentManager.beginTransaction()
            .replace(containerViewId, fragment)
            .addToBackStack(fragment.TAG)
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