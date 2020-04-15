package com.demo.oslaborganizer.data.model

import androidx.lifecycle.MutableLiveData
import java.util.*

class LabClass constructor(val classNum: Int, val date: String) {
    val tasks = MutableLiveData<MutableList<LabTask>>()
}