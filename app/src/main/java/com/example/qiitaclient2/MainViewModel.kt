package com.example.qiitaclient2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var headerVisibility: MutableLiveData<Boolean> = MutableLiveData()
    init {
        headerVisibility.value = false
    }
}