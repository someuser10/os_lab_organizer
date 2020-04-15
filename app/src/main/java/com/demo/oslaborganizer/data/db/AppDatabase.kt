package com.demo.oslaborganizer.data.db

import androidx.room.Database
import androidx.room.Entity
import androidx.room.RoomDatabase
import com.demo.oslaborganizer.data.model.LabClass
import com.demo.oslaborganizer.data.model.LabTask

@Database(entities = [LabClass::class, LabTask::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun labClassDao() : Dao;
}