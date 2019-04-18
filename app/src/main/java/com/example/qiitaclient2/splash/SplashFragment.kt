package com.example.qiitaclient2.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.qiitaclient2.R

class SplashFragment : Fragment() {

    private lateinit var titleView: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_splash, container, false)
        titleView = view.findViewById(R.id.title)

        val thread = Thread(Runnable {
            Thread.sleep(2000)
            startAnimation(view)
        })
        thread.start()

        return view
    }

    private fun startAnimation(view: View) {
        val animation: Animation = AnimationUtils.loadAnimation(activity?.applicationContext, R.anim.animation_splash)
        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(p0: Animation?) {
                // NOP
            }

            override fun onAnimationEnd(p0: Animation?) {
                titleView.visibility = View.GONE
                val thread = Thread(Runnable {
                    Thread.sleep(1000)
                    Navigation.findNavController(view).navigate(R.id.action_first_to_second)
                })
                thread.start()
            }

            override fun onAnimationRepeat(p0: Animation?) {
                // NOP
            }
        })
        titleView.startAnimation(animation)
    }


}