package com.yatochk.travelclock2.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Settings(
    @PrimaryKey
    val version: Int,
    val volume: Int,
    val distance: Int,
    val vibration: Boolean,
    val isFollow: Boolean
)