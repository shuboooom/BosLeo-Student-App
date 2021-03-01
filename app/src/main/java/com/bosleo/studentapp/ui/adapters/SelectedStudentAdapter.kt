package com.bosleo.studentapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bosleo.studentapp.data.pojo.Student
import com.bosleo.studentapp.databinding.ItemSelectedStudentBinding


class SelectedStudentAdapter(var list: ArrayList<Student>, private val onItemClick: ((Student) -> Unit))
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    fun updateList(newlist: ArrayList<Student>) {


        val diffResult = DiffUtil.calculateDiff(object : DiffUtil.Callback() {
            override fun getOldListSize(): Int {
                return list.size
            }

            override fun getNewListSize(): Int {
                return newlist.size
            }

            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                    val oldCtune = list[oldItemPosition]
                    val newCtune = newlist[newItemPosition]
                    return oldCtune.id == newCtune.id

            }

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return list[oldItemPosition] == newlist[newItemPosition]
            }
        })

        list = newlist

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
                LayoutInflater.from(parent.context),
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