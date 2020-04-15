package com.demo.oslaborganizer.ui.labtask

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.demo.oslaborganizer.R
import com.demo.oslaborganizer.data.model.LabTask
import kotlinx.android.synthetic.main.item_lab_task.view.*


class LabTaskAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var taskList: List<LabTask> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return LabClassListViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_lab_task, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is LabClassListViewHolder -> {
                holder.bind(taskList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    fun supplyLabClassList(labTasks: List<LabTask>) {
        this.taskList = labTasks
        notifyDataSetChanged()
    }


    class LabClassListViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bind(task: LabTask) {
            itemView.task_title.text = task.taskTitle
            itemView.task_code_et.text = task.labTaskCode
            itemView.task_notes_comment.text = task.comment
        }
    }
}