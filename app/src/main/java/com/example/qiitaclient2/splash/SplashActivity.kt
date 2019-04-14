package com.example.qiitaclient2.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProviders
import com.example.qiitaclient2.R
import com.example.qiitaclient2.core.AsyncCallBack
import com.example.qiitaclient2.MainActivity

class SplashActivity : AppCompatActivity() {

    lateinit var viewModel: SplashViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimaryDark)
        viewModel = ViewModelProviders.of(this).get(SplashViewModel::class.java)

        val title: View by lazy {
            findViewById<View>(R.id.title)
        }

        val anim: Animation = AnimationUtils.loadAnimation(this, R.anim.animation_splash)

        title.startAnimation(anim)

        class CallBack : AsyncCallBack {
            override fun onFinish() {
                startActivity(
                    Intent(
                        applicationContext,
                        MainActivity::class.java
                    )
                )
                overridePendingTransition(0, 0)
                finish()
            }
        }
        viewModel.startTopActivity(CallBack())
    }

}
