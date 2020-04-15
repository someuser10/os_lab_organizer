package com.demo.oslaborganizer.data.db

import androidx.lifecycle.MutableLiveData
import com.demo.oslaborganizer.data.model.LabClass
import com.demo.oslaborganizer.data.model.LabTask

interface IDbDtaSource {
    fun addLabClass(labClass: LabClass)
    fun addLabTask(classNumber: Int, task: LabTask)

    fun findByClassNumber(classNumber: Int): LabClass?
    fun getTasksByClassNumber(classNumber: Int): MutableLiveData<LabTask>?
    fun getAllClasses(classNumber: Int): MutableLiveData<MutableList<LabClass>>?
}