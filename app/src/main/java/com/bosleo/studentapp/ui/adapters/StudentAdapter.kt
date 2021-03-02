package com.bosleo.studentapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bosleo.studentapp.R
import com.bosleo.studentapp.data.pojo.Student
import com.bosleo.studentapp.databinding.ItemStudentBinding


class StudentAdapter(var list: List<Student>, private val onItemClick: ((Student) -> Unit))
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



    class MyViewHolder(itemStudentBinding: ItemStudentBinding) : RecyclerView.ViewHolder(itemStudentBinding.root) {
        val ui: ItemStudentBinding = itemStudentBinding

    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {

        val holder = MyViewHolder(
            ItemStudentBinding.inflate(
                LayoutInflater.from(parent.context),
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