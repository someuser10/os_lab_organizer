package com.demo.oslaborganizer.ui.labclass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.demo.oslaborganizer.R
import com.demo.oslaborganizer.data.TestRepository
import com.demo.oslaborganizer.ui.labtask.LabTaskActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), LabClassListAdapter.LabClassListener {

    private val testRepository = TestRepository.getInstance();
    private lateinit var labClassListAdapter: LabClassListAdapter;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        handleAddClass()

        testRepository.allClass.observe(this, Observer {
            labClassListAdapter.supplyLabClassList(it.toList())
        })

    }

    private fun handleAddClass() {
        add_class_fab.setOnClickListener {
            val intent = Intent(applicationContext, AddClassActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initRecyclerView() {
        labClassListAdapter = LabClassListAdapter(this)
        lab_class_listRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = labClassListAdapter
        }
        // labClassListAdapter.supplyLabClassList(listOf(LabClass(1, "Date: ")))
    }

    override fun onClassClick(position: Int) {
        val intent = Intent(this@MainActivity, LabTaskActivity::class.java)
        intent.putExtra("class_number", labClassListAdapter.labClassList[position].classNum)
        startActivity(intent)
    }

    override fun onUpdateButtonClick(classPosition: Int) {
        Toast.makeText(this, "upd", Toast.LENGTH_LONG).show()
    }

    override fun onDeleteClick(classPosition: Int) {
        Toast.makeText(this, "del", Toast.LENGTH_LONG).show()
    }
}
