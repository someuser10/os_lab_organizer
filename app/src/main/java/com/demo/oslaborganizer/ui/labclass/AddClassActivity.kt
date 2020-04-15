package com.demo.oslaborganizer.ui.labclass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.TestLooperManager
import android.view.View
import com.demo.oslaborganizer.R
import com.demo.oslaborganizer.data.TestRepository
import com.demo.oslaborganizer.data.model.LabClass
import kotlinx.android.synthetic.main.activity_add_class.*
import java.util.*

class AddClassActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_class)

        val testRepository: TestRepository = TestRepository.getInstance()

        add_class_floatingActionButton.setOnClickListener {
            val cn = classNumberEditText.text.toString().toInt()
            val bak: MutableList<LabClass>? = testRepository.allClass.value

            if (bak == null) {
                testRepository.allClass.value = mutableListOf(LabClass(cn, Date().toString()))
            } else {
                bak.add(LabClass(cn, Date().toString()))
                testRepository.allClass.value = bak;
            }
            startActivity(Intent(applicationContext, MainActivity::class.java))
        }
    }
}
