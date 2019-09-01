package com.yatochk.travelclock2.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yatochk.travelclock2.R

class SelectFragment : BaseFragment() {

    override val TAG: String = SelectFragment::class.java.simpleName

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_select, container, false)
    }
}