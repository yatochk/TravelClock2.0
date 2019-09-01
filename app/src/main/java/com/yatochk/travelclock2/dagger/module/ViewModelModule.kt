package com.yatochk.travelclock2.dagger.module

import androidx.lifecycle.ViewModel
import com.yatochk.travelclock2.dagger.ViewModelKey
import com.yatochk.travelclock2.viewmodel.MainActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    internal abstract fun newMainActivityViewModel(viewModel: MainActivityViewModel): ViewModel
}