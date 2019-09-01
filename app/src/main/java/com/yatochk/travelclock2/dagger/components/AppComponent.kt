package com.yatochk.travelclock2.dagger.components

import com.yatochk.travelclock2.dagger.module.AppModule
import com.yatochk.travelclock2.dagger.module.ViewModelModule
import com.yatochk.travelclock2.views.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {
    fun injectMainActivity(mainActivity: MainActivity)
}