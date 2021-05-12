package com.mimmer.viggosidle

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.Room
import com.mimmer.viggosidle.Database.AppDatabase
import com.mimmer.viggosidle.Database.DatabaseBuilder
import com.mimmer.viggosidle.Database.DbHelper
import com.mimmer.viggosidle.Database.DbHelperImpl
import kotlinx.coroutines.*

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val dbHelper = DbHelperImpl(DatabaseBuilder.getInstance(application))

    var currentScore = 0

    init {
        runBlocking {
            currentScore = dbHelper.getCurrentScore()
        }
    }



    private val _drinkText = MutableLiveData<String>().apply {
        value = "This is the drink Fragment"
    }

    private var _score = MutableLiveData<Int>().apply {
        value = currentScore
    }

    val text: LiveData<String> = _drinkText

    fun getScore(): MutableLiveData<Int> {
        return _score
    }
    fun setScore(){
        _score.value = currentScore
        runBlocking {
            dbHelper.setCurrentScore(currentScore)
        }

    }

}