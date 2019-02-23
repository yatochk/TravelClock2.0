package com.yatochk.travelclock2.dagger.Components

import com.yatochk.travelclock2.views.MainActivity
import dagger.Component

@Component
interface AppComponent {
    fun injectMainActivity(mainActivity: MainActivity)
}