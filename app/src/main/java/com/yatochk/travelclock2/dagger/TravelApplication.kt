package com.yatochk.travelclock2.dagger

import android.app.Application
import com.yatochk.travelclock2.dagger.components.AppComponent
import com.yatochk.travelclock2.dagger.components.DaggerAppComponent
import com.yatochk.travelclock2.dagger.module.AppModule

class TravelApplication : Application() {

    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

}