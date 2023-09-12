package com.techsultan.hngxstage2.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.techsultan.hngxstage2.model.Resume
import com.techsultan.hngxstage2.repository.ResumeRepository
import kotlinx.coroutines.launch

class ResumeViewModel(private val repository: ResumeRepository) : ViewModel() {

    fun addResume(resume: Resume) = viewModelScope.launch {
        repository.addResume(resume)
    }

    fun updateResume(resume: Resume) = viewModelScope.launch {
        repository.updateResume(resume)
    }

    fun getResumeDetails() = repository.getResume()
}


class ResumeViewModelFactory(private val repository: ResumeRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ResumeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ResumeViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}