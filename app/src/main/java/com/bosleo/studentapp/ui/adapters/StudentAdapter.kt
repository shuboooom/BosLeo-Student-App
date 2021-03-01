package com.bosleo.studentapp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bosleo.studentapp.R
import com.bosleo.studentapp.data.pojo.Student
import com.bosleo.studentapp.databinding.ItemStudentBinding


class StudentAdapter(var list: ArrayList<Student>, private val onItemClick: ((Student) -> Unit))
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    fun updateList(ctunesList: ArrayList<Student>) {


        val diffResult = DiffUtil.calculateDiff(object : DiffUtil.Callback() {
            override fun getOldListSize(): Int {
                return list.size
            }

            override fun getNewListSize(): Int {
                return ctunesList.size
            }

            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                    val oldCtune = list[oldItemPosition]
                    val newCtune = ctunesList[newItemPosition]
                    return oldCtune.id == newCtune.id

            }

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return list[oldItemPosition] == ctunesList[newItemPosition]
            }
        })

        list = ctunesList

        diffResult.dispatchUpdatesTo(this)

    }



    class MyViewHolder(itemStudentBinding: ItemStudentBinding) : RecyclerView.ViewHolder(itemStudentBinding.root) {
        val ui: ItemStudentBinding = itemStudentBinding

    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {

        val holder = MyViewHolder(
            ItemStudentBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent, false
            )
        )

//        holder.ui.checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
//            onItemClick(list[holder.adapterPosition])
//        }

        holder.ui.container.setOnClickListener {
            onItemClick(list[holder.adapterPosition])
        }

        return holder
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {

        val data = list[holder.adapterPosition]
        holder as MyViewHolder
        holder.ui.studentName.text = data.name

        holder.ui.selectIcon.setImageResource(if(data.isSelected){R.drawable.ic_check_circle_24px}
        else{R.drawable.ic_check_circle_outline_24px})
    }



    override fun getItemCount(): Int {
        return list.size
    }



}