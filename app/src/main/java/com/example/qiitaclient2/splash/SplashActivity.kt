package com.example.qiitaclient2.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.example.qiitaclient2.R
import com.example.qiitaclient2.core.AsyncCallBack
import com.example.qiitaclient2.top.TopActivity

class SplashActivity : AppCompatActivity() {

    lateinit var viewModel: SplashViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)
        viewModel = ViewModelProviders.of(this).get(SplashViewModel::class.java)

        val splashView: View by lazy {
            findViewById<View>(R.id.splash)
        }

        splashView.startAnimation(viewModel.createAnimation())

        class CallBack() : AsyncCallBack {
            override fun onFinish() {
                startActivity(
                    Intent(
                        applicationContext,
                        TopActivity::class.java
                    )
                )
                overridePendingTransition(0, 0)
                finish()
            }
        }
        viewModel.startTopActivity(CallBack())
    }



}
