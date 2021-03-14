package com.mimmer.viggosidle.ui.drink

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DrinkViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is the drink Fragment"
    }
    val text: LiveData<String> = _text
}