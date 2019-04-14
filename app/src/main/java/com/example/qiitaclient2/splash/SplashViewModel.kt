package com.example.qiitaclient2.splash

import androidx.lifecycle.ViewModel
import com.example.qiitaclient2.core.AsyncCallBack
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {
    private val showingTime = 2000L


    fun startTopActivity(callback: AsyncCallBack) {
        GlobalScope.launch {
            delay(showingTime)
            callback.onFinish()
        }
    }
}
