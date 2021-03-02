package com.bosleo.studentapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bosleo.studentapp.R
import com.bosleo.studentapp.data.database.DivisonWithStudents
import com.bosleo.studentapp.data.pojo.Divison
import com.bosleo.studentapp.data.pojo.Student
import com.bosleo.studentapp.databinding.ItemDivisonBinding
import com.bosleo.studentapp.databinding.ItemStudentBinding


class DivisonAdapter(var list: List<DivisonWithStudents>, private val onItemClick: ((Student) -> Unit))
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val viewPool = RecyclerView.RecycledViewPool()

    fun updateList(newlist: List<DivisonWithStudents>) {


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
                    return oldCtune.divison.id == newCtune.divison.id

            }

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return list[oldItemPosition] == newlist[newItemPosition]
            }
        })

        list = newlist

        diffResult.dispatchUpdatesTo(this)

    }



    class MyViewHolder(itemStudentBinding: ItemDivisonBinding) : RecyclerView.ViewHolder(itemStudentBinding.root) {
        val ui: ItemDivisonBinding = itemStudentBinding

    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {

        val holder = MyViewHolder(
                ItemDivisonBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )

//        holder.ui.checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
//            onItemClick(list[holder.adapterPosition])
//        }

//        holder.ui.container.setOnClickListener {
//            onItemClick(list[holder.adapterPosition])
//        }

        return holder
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {

        val data = list[holder.adapterPosition]
        holder as MyViewHolder
        holder.ui.divisonName.text = data.divison.division

        val childLayoutManager = LinearLayoutManager(holder.ui.rvSub.context, RecyclerView.VERTICAL, false)
        holder.ui.rvSub.apply {
            layoutManager = childLayoutManager
            adapter = StudentAdapter(data.students)
            {
                onItemClick(it)
            }
            setRecycledViewPool(viewPool)
        }

    }



    override fun getItemCount(): Int {
        return list.size
    }



}