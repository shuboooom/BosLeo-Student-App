package com.bosleo.studentapp.viewmodels

import androidx.lifecycle.ViewModel
import com.bosleo.studentapp.data.repository.StudentRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StudentViewModel @Inject constructor (private val studentRepo: StudentRepo) : ViewModel() {

    val allStudents = studentRepo.getAllStudents()

}