package com.mimmer.viggosidle

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.Room
import com.mimmer.viggosidle.Database.AppDatabase
import com.mimmer.viggosidle.Database.DatabaseBuilder
import com.mimmer.viggosidle.Database.DbHelper
import com.mimmer.viggosidle.Database.DbHelperImpl

class MainViewModel() : ViewModel() {


    var currentScore = 0

    private val _text = MutableLiveData<String>().apply {
        value = "This is the drink Fragment"
    }

    private var _score = MutableLiveData<Int>().apply {
        value = currentScore
    }

    val text: LiveData<String> = _text

    fun getScore(): MutableLiveData<Int> {
        return _score
    }
    fun setScore(){
        _score.value = currentScore
    }
}