package com.mimmer.viggosidle.Database

interface DbHelper {
    suspend fun getAll(): List<Player>
    suspend fun insertPlayer(player: Player?)
    suspend fun getCurrentScore(): Int
    suspend fun setCurrentScore(int: Int)
}