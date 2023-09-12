package com.techsultan.hngxstage2

import android.app.Application
import com.techsultan.hngxstage2.database.ResumeDatabase
import com.techsultan.hngxstage2.repository.ResumeRepository

class ResumeApplication: Application() {

    val database by lazy { ResumeDatabase.createDatabase(this) }
    val repository by lazy { ResumeRepository(database.resumeDao()) }
}