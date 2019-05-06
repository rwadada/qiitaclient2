package com.example.qiitaclient2.custom.view

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProviders
import com.example.qiitaclient2.R
import com.example.qiitaclient2.databinding.DialogMonthPickBinding

class MonthPickerDialog : DialogFragment() {
    lateinit var viewModel: MonthPickerViewModel
    lateinit var binding: DialogMonthPickBinding
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = Dialog(activity!!)
        viewModel = ViewModelProviders.of(this).get(MonthPickerViewModel::class.java)
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.dialog_month_pick, null, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.handler = this
        dialog.setContentView(binding.root)


        return dialog
    }

    fun onCheckRadioButton(view: View) {
        when(view.id) {
            R.id.month_jan -> viewModel.select(MonthPickerViewModel.Month.JANUARY)
            R.id.month_feb -> viewModel.select(MonthPickerViewModel.Month.FEBRUARY)
            R.id.month_mar -> viewModel.select(MonthPickerViewModel.Month.MARCH)
            R.id.month_apr -> viewModel.select(MonthPickerViewModel.Month.APRIL)
            R.id.month_may -> viewModel.select(MonthPickerViewModel.Month.MAY)
            R.id.month_jun -> viewModel.select(MonthPickerViewModel.Month.JUNE)
            R.id.month_jul -> viewModel.select(MonthPickerViewModel.Month.JULY)
            R.id.month_aug -> viewModel.select(MonthPickerViewModel.Month.AUGUST)
            R.id.month_sep -> viewModel.select(MonthPickerViewModel.Month.SEPTEMBER)
            R.id.month_oct -> viewModel.select(MonthPickerViewModel.Month.OCTOBER)
            R.id.month_nov -> viewModel.select(MonthPickerViewModel.Month.NOVEMBER)
            R.id.month_dec -> viewModel.select(MonthPickerViewModel.Month.DECEMBER)
        }
    }
}