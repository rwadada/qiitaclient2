package com.example.qiitaclient2.login

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.qiitaclient2.R
import com.example.qiitaclient2.data.container.Container
import com.example.qiitaclient2.data.container.LoginContainer
import com.example.qiitaclient2.data.container.Targets
import com.example.qiitaclient2.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentLoginBinding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_login,
                container,
                false)

        binding.listener = this

        return binding.root
    }

    fun doLogin(view: View) {
        val container: Container = LoginContainer()
        val uri: String = container.getData(Targets.LOGINURL, mapOf())
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
    }

    fun doGuestLogin(view: View) {
        Log.d(javaClass.simpleName,"working")
        Navigation.findNavController(view).navigate(R.id.login_to_top)
    }

}