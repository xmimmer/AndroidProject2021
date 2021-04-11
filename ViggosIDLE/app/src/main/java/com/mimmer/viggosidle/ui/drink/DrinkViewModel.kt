package com.mimmer.viggosidle.ui.drink

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mimmer.viggosidle.MainActivity

class DrinkViewModel : ViewModel() {


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




