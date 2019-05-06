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
import androidx.navigation.fragment.findNavController
import com.example.qiitaclient2.R
import com.example.qiitaclient2.data.container.Container
import com.example.qiitaclient2.data.container.LoginContainer
import com.example.qiitaclient2.data.container.Targets
import com.example.qiitaclient2.databinding.FragmentLoginBinding
import com.example.qiitaclient2.top.TopFragmentArgs

class LoginFragment : Fragment() {
    val TAG: String = LoginFragment::class.java.simpleName

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
        Log.d(TAG, view.toString())
        val container: Container = LoginContainer()
        val uri: String = container.getData(Targets.LOGINURL, mapOf())
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
    }

    fun doGuestLogin(view: View) {
        Log.d(TAG, view.toString())
        Log.d(javaClass.simpleName,"working")
        findNavController().navigate(
            LoginFragmentDirections
                .actionLoginFragmentToTopFragment(
                    code = "guest",
                    state = "guest")
        )
    }

}