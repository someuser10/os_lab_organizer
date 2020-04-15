package com.demo.oslaborganizer.ui.labtask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.demo.oslaborganizer.R
import com.demo.oslaborganizer.data.TestRepository
import kotlinx.android.synthetic.main.activity_lab_task.*

class LabTaskActivity : AppCompatActivity() {

    private var adapter: LabTaskAdapter = LabTaskAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab_task)

        recyclerView.apply {
            adapter = this@LabTaskActivity.adapter
            layoutManager = LinearLayoutManager(this@LabTaskActivity)
        }


        val classNum = intent.getIntExtra("class_number", 0)
        val repo = TestRepository.getInstance()
        val classFilter = repo.allClass.value?.filter { it.classNum == classNum }

        // Toast.makeText(this, "total classes: $classFilter", Toast.LENGTH_SHORT).show()

        if (classFilter != null && classFilter.isNotEmpty()) {
            val cls = classFilter[0];
            cls.tasks.observe(this, Observer {
                adapter.supplyLabClassList(it.toList())
            })
        }

        add_task_fab.setOnClickListener {
            val intent = Intent(applicationContext, AddTaskActivity::class.java)
            intent.putExtra("class_number", classNum)
            startActivity(intent)
        }

    }
}
