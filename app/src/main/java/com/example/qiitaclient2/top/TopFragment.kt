package com.example.qiitaclient2.top

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.qiitaclient2.R
import com.example.qiitaclient2.core.ApplicationHolder

class TopFragment : Fragment() {

    private lateinit var viewModel: TopViewModel

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        ApplicationHolder.viewHandler.visibleHeader()
        val view: View = inflater.inflate(R.layout.top_fragment, container, false)
        val listView: ListView = view.findViewById(R.id.list)
        val mainView: View = view.findViewById(R.id.main_view)
        val lp: ViewGroup.MarginLayoutParams = mainView.layoutParams as ViewGroup.MarginLayoutParams
        var headerSize: Int = lp.topMargin

        listView.setOnTouchListener { _, _ ->
            if (headerSize <= 0) {
                false
            } else {
                headerSize -= 10
                lp.topMargin = headerSize
                mainView.layoutParams = lp
                true
            }
        }
        val itemList: Array<String> = arrayOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20")
        val adapter: ArrayAdapter<String> = ArrayAdapter(context!!, android.R.layout.simple_list_item_1, itemList)
        listView.adapter = adapter

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TopViewModel::class.java)
    }

}
