package com.mimmer.viggosidle.Database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PlayerDao {
    @Insert
    suspend fun insertPlayer(player: Player?)
    @Delete
    suspend fun delete(player: Player)

    @Query("SELECT * FROM Player")
    suspend fun getAll(): List<Player>

    @Query("SELECT current_score FROM Player")
    suspend fun getCurrentScore(): Int

    @Query("UPDATE Player SET current_score = :int WHERE uid = 1")
    suspend fun setCurrentScore(int: Int)

    @Query("SELECT clicking_power FROM Player")
    suspend fun getClickingPower(): Int

    @Query("UPDATE Player SET clicking_power = :int WHERE uid=1")
    suspend fun setClickingPower(int: Int)

    @Query("UPDATE Player SET current_score = 0 WHERE uid = 1")
    suspend fun resetScore(): Unit

    @Query("UPDATE Player SET clicking_power = 1 WHERE uid = 1")
    suspend fun resetClickingPower(): Unit

    @Query("SELECT idle_gains FROM Player")
    suspend fun getIdleGains(): Int

    @Query("UPDATE Player SET idle_gains = :int WHERE uid = 1")
    suspend fun setIdleGains(int: Int)

    @Query("UPDATE Player SET idle_gains = 0 WHERE uid = 1")
    suspend fun resetIdleGains(): Unit

}