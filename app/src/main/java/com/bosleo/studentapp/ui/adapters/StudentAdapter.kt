package com.bosleo.studentapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bosleo.studentapp.R
import com.bosleo.studentapp.data.pojo.Student
import com.bosleo.studentapp.databinding.ItemStudentBinding


class StudentAdapter(var list: List<Student>, private val onItemClick: ((Student) -> Unit))
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class MyViewHolder(itemStudentBinding: ItemStudentBinding) : RecyclerView.ViewHolder(itemStudentBinding.root) {
        val ui: ItemStudentBinding = itemStudentBinding

    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {

        return MyViewHolder(
            ItemStudentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
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

        holder.ui.container.setOnClickListener {
            onItemClick(list[position])
        }
    }



    override fun getItemCount(): Int {
        return list.size
    }



}