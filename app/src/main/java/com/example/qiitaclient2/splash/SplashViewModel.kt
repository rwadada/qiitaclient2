package com.example.qiitaclient2.splash

import android.view.animation.AlphaAnimation
import androidx.lifecycle.ViewModel
import com.example.qiitaclient2.core.AsyncCallBack
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {
    private val showingTime = 3500L

    fun createAnimation(): AlphaAnimation {
        val anim = AlphaAnimation(1f, 0f)
        anim.duration = showingTime
        return anim
    }

    fun startTopActivity(callback: AsyncCallBack) {
        GlobalScope.launch {
            delay(showingTime)
            callback.onFinish()
        }
    }
}
