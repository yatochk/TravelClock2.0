package com.yatochk.travelclock2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yatochk.travelclock2.views.MainState
import javax.inject.Inject

class MainActivityViewModel @Inject constructor() : ViewModel() {

    private val mutableState = MutableLiveData<MainState>()
    val state: LiveData<MainState> = mutableState

}