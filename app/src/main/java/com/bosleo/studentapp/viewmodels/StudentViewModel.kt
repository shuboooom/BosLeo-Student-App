package com.bosleo.studentapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bosleo.studentapp.data.repository.StudentRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StudentViewModel @Inject constructor (private val studentRepo: StudentRepo) : ViewModel() {

    val allStudents = studentRepo.getAllStudents()

    fun fetchData()
    {
        viewModelScope.launch { studentRepo.getClassData() }
    }
}