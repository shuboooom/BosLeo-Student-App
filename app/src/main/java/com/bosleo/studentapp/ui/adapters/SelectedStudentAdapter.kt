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
import com.bosleo.studentapp.databinding.ItemSelectedStudentBinding
import com.bosleo.studentapp.databinding.ItemStudentBinding


class SelectedStudentAdapter(var list: ArrayList<Student>, private val onItemClick: ((Student) -> Unit))
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



    class MyViewHolder(itemStudentBinding: ItemSelectedStudentBinding) : RecyclerView.ViewHolder(itemStudentBinding.root) {
        val ui: ItemSelectedStudentBinding = itemStudentBinding

    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {

        val holder = MyViewHolder(
            ItemSelectedStudentBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent, false
            )
        )


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
    }



    override fun getItemCount(): Int {
        return list.size
    }



}