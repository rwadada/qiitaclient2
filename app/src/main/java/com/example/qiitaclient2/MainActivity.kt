package com.example.qiitaclient2

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.qiitaclient2.core.ApplicationHolder
import com.example.qiitaclient2.core.setData
import com.example.qiitaclient2.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: MainActivityBinding =
            DataBindingUtil.setContentView(this, R.layout.main_activity) as MainActivityBinding
        binding.lifecycleOwner = this

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        if (intent.data is Uri && intent.data != null) {
            ApplicationHolder.queryParams.setData(
                intent.data!!.getQueryParameter("code"),
                intent.data!!.getQueryParameter("state")
            )
        }
        binding.viewModel = viewModel
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimaryDark)
        ApplicationHolder.viewHandler = viewHandler

    }

    private val viewHandler: ViewHandler = object : ViewHandler {
        override fun visibleHeader() {
            viewModel.headerVisibility.value = true
        }

        override fun visibleFooter() {
            // NOP
        }
    }
}
