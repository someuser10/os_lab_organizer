package com.demo.oslaborganizer.ui.labclass

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.demo.oslaborganizer.R
import com.demo.oslaborganizer.data.model.LabClass
import kotlinx.android.synthetic.main.item_lab_class.view.*


class LabClassListAdapter(private val labClassListener: LabClassListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var labClassList: List<LabClass> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return LabClassListViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_lab_class, parent, false
            ), labClassListener
        )
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is LabClassListViewHolder -> {
                holder.bind(labClassList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return labClassList.size
    }

    fun supplyLabClassList(labClassList: List<LabClass>) {
        this.labClassList = labClassList
    }

    class LabClassListViewHolder constructor(
        itemView: View,
        private val labClassListener: LabClassListener
    ) :
        RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
            itemView.delete_class_imageView.setOnClickListener(this)
            itemView.edit_class_imgView.setOnClickListener(this)
        }

        fun bind(labClass: LabClass) {
            itemView.class_textView.text = "Class ${labClass.classNum}"
            itemView.class_infoTextView.text = labClass.date;
        }

        override fun onClick(v: View?) {
            when (v?.id) {
                R.id.edit_class_imgView -> {
                    labClassListener.onUpdateButtonClick(adapterPosition)
                }
                R.id.delete_class_imageView -> {
                    labClassListener.onDeleteClick(adapterPosition)
                }
                R.id.lab_class_item_layout -> {
                    labClassListener.onClassClick(adapterPosition)
                }
                else -> {
                    labClassListener.onClassClick(adapterPosition)
                }
            }
        }
    }

    interface LabClassListener {
        fun onClassClick(position: Int)
        fun onUpdateButtonClick(classPosition: Int)
        fun onDeleteClick(classPosition: Int)
    }

}