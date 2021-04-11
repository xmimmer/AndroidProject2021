package com.mimmer.viggosidle.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Player(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "glass_number") val glassNumber: String?,
    @ColumnInfo(name = "current_score") val currentScore: Int?,
    @ColumnInfo(name = "clicking_power") val clickingPower: Int?,
    @ColumnInfo(name = "idle_gains") val idleGains: Int?
)
