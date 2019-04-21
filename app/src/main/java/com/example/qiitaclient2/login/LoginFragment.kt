package com.example.qiitaclient2.login

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.qiitaclient2.R
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

    }

    fun doGuestLogin(view: View) {
        Log.d(javaClass.simpleName,"working")
        Navigation.findNavController(view).navigate(R.id.login_to_top)
    }

}