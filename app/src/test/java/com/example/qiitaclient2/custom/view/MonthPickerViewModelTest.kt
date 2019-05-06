package com.example.qiitaclient2.custom.view

import org.junit.Assert.*
import org.junit.Test

class MonthPickerViewModelTest {
    @Test
    fun testSelectMonth(){
        val monthPickerViewModel = MonthPickerViewModel()
        monthPickerViewModel.select(MonthPickerViewModel.Month.FEBRUARY)
        assertEquals(monthPickerViewModel.january.value, false)
        assertEquals(monthPickerViewModel.february.value, true)
    }
}