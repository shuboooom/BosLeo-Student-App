package com.bosleo.studentapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bosleo.studentapp.data.repository.StudentRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StudentViewModel @Inject constructor (private val studentRepo: StudentRepo) : ViewModel() {

    val allDivisons = studentRepo.getAllDivisions()
    val selectedStudents = studentRepo.getSelectedStudents()

    init {
        viewModelScope.launch { studentRepo.uncheckAll() }
    }

    fun fetchData()
    {
        viewModelScope.launch { studentRepo.getClassData() }
    }

    fun checkUncheck(student_id : String,value : Boolean)
    {
        viewModelScope.launch { studentRepo.checkUncheck(student_id,value) }
    }
}