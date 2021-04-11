package com.mimmer.viggosidle.Database

class DbHelperImpl (private val appDatabase: AppDatabase) : DbHelper {
    override suspend fun getAll(): List<Player> = appDatabase.playerDao().getAll()


    override suspend fun insertPlayer(player: Player?) = appDatabase.playerDao().insertPlayer(player)

    override suspend fun getCurrentScore(): Int = appDatabase.playerDao().getCurrentScore()



}