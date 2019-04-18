package com.example.qiitaclient2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.qiitaclient2.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: MainActivityBinding =
            DataBindingUtil.setContentView(this, R.layout.main_activity) as MainActivityBinding
        binding.lifecycleOwner = this

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.viewModel = viewModel
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimaryDark)

    }

    fun visibleHeader() {
        viewModel.headerVisibility.value = true
    }
}
