package com.mimmer.viggosidle.Database

interface DbHelper {
    suspend fun getAll(): List<Player>
    suspend fun insertPlayer(player: Player?)
    suspend fun getCurrentScore(): Int
    suspend fun setCurrentScore(int: Int)
    suspend fun getClickingPower(): Int
    suspend fun setClickingPower(int: Int)
    suspend fun resetScore(): Unit
    suspend fun resetClickingPower(): Unit
    suspend fun resetIdleGains(): Unit
    suspend fun getIdleGains(): Int
    suspend fun setIdleGains(int: Int)
}