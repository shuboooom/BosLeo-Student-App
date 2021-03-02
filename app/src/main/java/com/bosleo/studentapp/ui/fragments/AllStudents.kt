package com.bosleo.studentapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bosleo.studentapp.databinding.FragmentStudentsBinding
import com.bosleo.studentapp.ui.adapters.DivisonAdapter
import com.bosleo.studentapp.utils.beGone
import com.bosleo.studentapp.utils.beVisible
import com.bosleo.studentapp.viewmodels.StudentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AllStudents : Fragment() {

    private val viewModel : StudentViewModel by activityViewModels()
    private var _binding: FragmentStudentsBinding? = null
    private val binding get() = _binding!!
    //private var studentAdapter: StudentAdapter? = null
    private var divisonAdapter: DivisonAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStudentsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.progressBar.beVisible()
        viewModel.allDivisons.observe(viewLifecycleOwner,{

            binding.progressBar.beGone()
            it?.let {
                studentList ->

                if(divisonAdapter == null){
                    divisonAdapter = DivisonAdapter(studentList) {
                        viewModel.checkUncheck(it.id,!it.isSelected)
                    }
                    binding.list.apply {
                        layoutManager = LinearLayoutManager(activity)
                        adapter = divisonAdapter
                    }
                }
                else
                {
                    divisonAdapter?.updateList(studentList)
                }

            }
        })
    }

}