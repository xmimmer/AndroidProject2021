package com.mimmer.viggosidle.Database

class DbHelperImpl (private val appDatabase: AppDatabase) : DbHelper {

    override suspend fun getAll(): List<Player> = appDatabase.playerDao().getAll()

    override suspend fun insertPlayer(player: Player?) = appDatabase.playerDao().insertPlayer(player)

    override suspend fun getCurrentScore(): Int = appDatabase.playerDao().getCurrentScore()

    override suspend fun setCurrentScore(int: Int) = appDatabase.playerDao().setCurrentScore(int)

    override suspend fun getClickingPower(): Int = appDatabase.playerDao().getClickingPower()

    override suspend fun setClickingPower(int: Int) = appDatabase.playerDao().setClickingPower(int)

    override suspend fun resetScore(): Unit = appDatabase.playerDao().resetScore()

    override suspend fun resetClickingPower(): Unit = appDatabase.playerDao().resetClickingPower()

    override suspend fun getIdleGains(): Int = appDatabase.playerDao().getIdleGains()

    override suspend fun setIdleGains(int: Int) = appDatabase.playerDao().setIdleGains(int)

    override suspend fun resetIdleGains(): Unit = appDatabase.playerDao().resetIdleGains()



}