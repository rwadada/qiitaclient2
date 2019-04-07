package com.example.qiitaclient2.top

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.qiitaclient2.R

class TopActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.top_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, TopFragment.newInstance())
                .commitNow()
        }
    }

}
