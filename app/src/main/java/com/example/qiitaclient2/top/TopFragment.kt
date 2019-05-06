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
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.qiitaclient2.R
import com.example.qiitaclient2.core.ApplicationHolder
import com.example.qiitaclient2.core.Status
import com.example.qiitaclient2.custom.view.MonthPickerDialog
import com.example.qiitaclient2.custom.view.MyAdapter
import com.example.qiitaclient2.databinding.LayoutEmptyBinding
import com.example.qiitaclient2.databinding.TopFragmentBinding
import java.lang.Exception

class TopFragment : Fragment() {

    private lateinit var viewModel: TopViewModel
    private lateinit var binding: TopFragmentBinding
    private lateinit var contentBinding: LayoutEmptyBinding

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.top_fragment, container, false)
        viewModel = ViewModelProviders.of(this).get(TopViewModel::class.java)
        val view: View = binding.root

        initBindings()

        viewModel.visibleContent()

        val args: TopFragmentArgs by navArgs()

        try {
            println("code = ${args.code}, state = ${args.state}")
            ApplicationHolder.status = Status.AUTHENTICATED
        } catch (e: Exception) {
            println("UnAuthenticated")
        }

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (ApplicationHolder.status == Status.UNAUTHENTICATED) {
            findNavController().navigate(R.id.firstFragment)
        }
    }

    fun onClickTitle(view: View) {
        if(viewModel.isContentExist.value!!) {
            viewModel.invisibleContent()
        } else {
            viewModel.visibleContent()
        }
    }

    private fun initBindings() {
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.handler = this

        contentBinding = binding.emptyView
        contentBinding.lifecycleOwner = this
        contentBinding.viewModel = viewModel
    }

    fun showMonthPicker(view: View) {
        val monthPicker = MonthPickerDialog()
        monthPicker.show(fragmentManager!!, MonthPickerDialog::class.java.simpleName)
    }

}
