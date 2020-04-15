package com.demo.oslaborganizer.ui.labtask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.demo.oslaborganizer.R
import com.demo.oslaborganizer.data.TestRepository
import com.demo.oslaborganizer.data.model.LabTask
import kotlinx.android.synthetic.main.activity_add_task.*
import kotlinx.android.synthetic.main.activity_add_task.task_code_et
import kotlinx.android.synthetic.main.item_lab_task.*
import java.lang.Exception

class AddTaskActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        val classNum = intent.getIntExtra("class_number", 0)
        val repository = TestRepository.getInstance()
        floatingActionButton.setOnClickListener {
            val task = LabTask(
                task_title_et.text.toString(),
                task_code_et.text.toString(),
                task_note_et.text.toString()
            )

            try {
                val allClass = repository.allClass.value!!

                val currentClass = allClass.filter { it.classNum == classNum }
                val currentTasksBak = currentClass[0].tasks.value
                if (currentTasksBak == null) {
                    currentClass[0].tasks.value = mutableListOf(task)
                } else {
                    currentTasksBak.add(task)
                    currentClass[0].tasks.value = currentTasksBak
                }
                startActivity(
                    Intent(
                        applicationContext,
                        LabTaskActivity::class.java
                    ).apply { putExtra("class_number", classNum) })
            } catch (e: Exception) {
                Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }
}
