package com.example.qiitaclient2.custom.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MonthPickerViewModel : ViewModel() {
    var january = MutableLiveData<Boolean>()
    var february = MutableLiveData<Boolean>()
    var march = MutableLiveData<Boolean>()
    var april = MutableLiveData<Boolean>()
    var may = MutableLiveData<Boolean>()
    var june = MutableLiveData<Boolean>()
    var july = MutableLiveData<Boolean>()
    var august = MutableLiveData<Boolean>()
    var september = MutableLiveData<Boolean>()
    var october = MutableLiveData<Boolean>()
    var november = MutableLiveData<Boolean>()
    var december = MutableLiveData<Boolean>()

    private val months = mutableListOf(
        january,
        february,
        march,
        april,
        may,
        june,
        july,
        august,
        september,
        october,
        november,
        december
    )

    private var selectedMonth = january

    init {
        for (month in months) {
            month.value = false
        }
        january.value = true
    }

    enum class Month{
        JANUARY,
        FEBRUARY,
        MARCH,
        APRIL,
        MAY,
        JUNE,
        JULY,
        AUGUST,
        SEPTEMBER,
        OCTOBER,
        NOVEMBER,
        DECEMBER
    }

    fun select(month: Month) {
        when(month) {
            Month.JANUARY -> {
                selectedMonth.value = false
                january.value = true
                selectedMonth = january
            }
            Month.FEBRUARY -> {
                selectedMonth.value = false
                february.value = true
                selectedMonth = february
            }
            Month.MARCH -> {
                selectedMonth.value = false
                march.value = true
                selectedMonth = march
            }
            Month.APRIL -> {
                selectedMonth.value = false
                april.value = true
                selectedMonth = april
            }
            Month.MAY -> {
                selectedMonth.value = false
                may.value = true
                selectedMonth = may
            }
            Month.JUNE -> {
                selectedMonth.value = false
                june.value = true
                selectedMonth = june
            }
            Month.JULY -> {
                selectedMonth.value = false
                july.value = true
                selectedMonth = july
            }
            Month.AUGUST -> {
                selectedMonth.value = false
                august.value = true
                selectedMonth = august
            }
            Month.SEPTEMBER -> {
                selectedMonth.value = false
                september.value = true
                selectedMonth = september
            }
            Month.OCTOBER -> {
                selectedMonth.value = false
                october.value = true
                selectedMonth = october
            }
            Month.NOVEMBER -> {
                selectedMonth.value = false
                november.value = true
                selectedMonth = november
            }
            Month.DECEMBER -> {
                selectedMonth.value = false
                december.value = true
                selectedMonth = december
            }
        }
    }

}


