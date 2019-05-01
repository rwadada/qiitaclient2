package com.example.qiitaclient2.top

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TopViewModel : ViewModel() {
    private var _isContentsExist = MutableLiveData<Boolean>()
    val isContentExist: LiveData<Boolean>
        get() = _isContentsExist

    init {
        _isContentsExist.value = false
    }
    fun visibleContent() {
        _isContentsExist.value = true
    }
    fun invisibleContent() {
        _isContentsExist.value = false
    }
}
