package com.yatochk.travelclock2.views

import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    abstract val TAG: String

    override fun onResume() {
        super.onResume()
        view?.isEnabled = true
    }

    override fun onPause() {
        super.onPause()
        view?.isEnabled = false
    }
}