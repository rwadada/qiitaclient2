package com.example.qiitaclient2

import androidx.databinding.ObservableBoolean

class Item {
    var headerVisibility: ObservableBoolean = ObservableBoolean()
    init {
        headerVisibility.set(false)
    }
}