package com.yatochk.travelclock2.dagger.components

import com.yatochk.travelclock2.views.MainActivity
import dagger.Component

@Component
interface AppComponent {
    fun injectMainActivity(mainActivity: MainActivity)
}