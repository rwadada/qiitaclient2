package com.example.qiitaclient2.splash

import android.content.Intent
import android.view.animation.AlphaAnimation
import androidx.lifecycle.ViewModel
import com.example.qiitaclient2.core.AsyncCallBack
import com.example.qiitaclient2.top.TopActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {
    fun createAnimation(): AlphaAnimation {
        val anim = AlphaAnimation(1f, 0f)
        anim.duration = 2000
        return anim
    }

    fun startTopActivity(callback: AsyncCallBack) {
        GlobalScope.launch {
            delay(2000L)
            callback.onFinish()
        }
    }
}
