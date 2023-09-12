package com.techsultan.hngxstage2.repository

import androidx.lifecycle.LiveData
import com.techsultan.hngxstage2.database.ResumeDao
import com.techsultan.hngxstage2.model.Resume

class ResumeRepository(private val dao: ResumeDao) {


    suspend fun addResume(resume: Resume) = dao.addResume(resume)
    suspend fun updateResume(resume: Resume) = dao.updateResume(resume)

    fun getResume() = dao.getResumeDetails()

}