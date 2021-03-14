package com.mimmer.viggosidle.ui.shop

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShopViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is the shop Fragment"
    }
    val text: LiveData<String> = _text
}