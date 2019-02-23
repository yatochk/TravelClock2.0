package com.hhade.travelclock_20.dagger.Components

import com.hhade.travelclock_20.views.main.MainActivity
import dagger.Component

@Component
interface AppComponent {
    fun injectMainActivity(mainActivity: MainActivity)
}