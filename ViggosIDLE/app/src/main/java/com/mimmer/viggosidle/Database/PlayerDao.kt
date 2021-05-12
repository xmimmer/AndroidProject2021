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
}