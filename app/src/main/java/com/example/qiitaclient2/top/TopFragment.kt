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
import android.widget.LinearLayout
import android.widget.ListView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.qiitaclient2.R
import com.example.qiitaclient2.core.ApplicationHolder
import com.example.qiitaclient2.custom.view.MyAdapter
import com.example.qiitaclient2.databinding.LayoutEmptyBinding
import com.example.qiitaclient2.databinding.TopFragmentBinding

class TopFragment : Fragment() {

    private lateinit var viewModel: TopViewModel
    private lateinit var binding: TopFragmentBinding
    private lateinit var contentBinding: LayoutEmptyBinding

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.top_fragment, container, false)
        viewModel = ViewModelProviders.of(this).get(TopViewModel::class.java)
        val view: View = binding.root

        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.handler = this

        contentBinding = binding.emptyView
        contentBinding.lifecycleOwner = this
        contentBinding.viewModel = viewModel

        viewModel.visibleContent()

        if (viewModel.isContentExist.value!!) {
            val mRecyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
            mRecyclerView.setHasFixedSize(true)

            val mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
            mRecyclerView.layoutManager = mLayoutManager

            val mDataset: MutableList<String> = mutableListOf()
            for (i:Int in 0..99) {
                mDataset.add("Data$i")
            }

            val mAdapter = MyAdapter(mDataset)
            mRecyclerView.adapter = mAdapter
        }

        return view
    }

    fun onClickTitle(view: View) {
        if(viewModel.isContentExist.value!!) {
            viewModel.invisibleContent()
        } else {
            viewModel.visibleContent()
        }
    }

}
