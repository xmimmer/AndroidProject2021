package com.mimmer.viggosidle.ui.drink

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DrinkViewModel : ViewModel() {

    var currentScore = 0

    private val _text = MutableLiveData<String>().apply {
        value = "This is the drink Fragment"
    }

    private var _score = MutableLiveData<Int>().apply {
        value = currentScore
    }

    val text: LiveData<String> = _text
    val score: LiveData<Int> = _score



}




