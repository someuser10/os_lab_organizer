package com.demo.oslaborganizer.data

import androidx.lifecycle.MutableLiveData
import com.demo.oslaborganizer.data.model.LabClass

class TestRepository private constructor() {

    companion object {
        private var instance: TestRepository? = null
        fun getInstance(): TestRepository {
            if (instance == null) instance = TestRepository()
            return instance!!
        }
    }

    val allClass: MutableLiveData<MutableList<LabClass>> = MutableLiveData()
}