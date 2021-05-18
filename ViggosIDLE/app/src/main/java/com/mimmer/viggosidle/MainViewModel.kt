package com.mimmer.viggosidle

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.mimmer.viggosidle.Database.DatabaseBuilder
import com.mimmer.viggosidle.Database.DbHelperImpl
import kotlinx.coroutines.runBlocking

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val dbHelper = DbHelperImpl(DatabaseBuilder.getInstance(application))

    var currentScore: Int
    var clickingPower: Int
    var idle_gains: Int

    init {
        runBlocking {
            currentScore = dbHelper.getCurrentScore()
            clickingPower = dbHelper.getClickingPower()
            idle_gains = dbHelper.getIdleGains()
        }
    }

    private var _score = MutableLiveData<Int>().apply {
        value = currentScore
    }

    private var _clicking_power = MutableLiveData<Int>().apply {
        value = clickingPower
    }

    fun getClickingPower():MutableLiveData<Int> {
        return _clicking_power
    }

    fun setClickingPower() {
        _clicking_power.value = clickingPower
        runBlocking {
            dbHelper.setClickingPower(clickingPower)
        }
    }

    fun getScore(): MutableLiveData<Int> {
        return _score
    }
    fun setScore(){
        _score.value = currentScore
        runBlocking {
            dbHelper.setCurrentScore(currentScore)
        }
    }

    private var _idle_gains = MutableLiveData<Int>().apply {
        value = idle_gains
    }

    fun getIdleGains(): MutableLiveData<Int> {
        return _idle_gains
    }

    fun setIdleGains() {
        _idle_gains.value = idle_gains
        runBlocking {
            dbHelper.setIdleGains(idle_gains)
        }
    }

    fun resetStats() {
        currentScore = 0
        clickingPower = 1
        idle_gains = 0

        _score.value = currentScore
        _clicking_power.value = clickingPower
        _idle_gains.value = idle_gains

        runBlocking {
            dbHelper.setCurrentScore(currentScore)
            dbHelper.setClickingPower(clickingPower)
            dbHelper.resetIdleGains()
        }
    }
}