package com.techsultan.hngxstage2.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.techsultan.hngxstage2.model.Resume


@Dao
interface ResumeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addResume(resume: Resume)

    @Update
    suspend fun updateResume(resume: Resume)

    @Query("SELECT * FROM resume LIMIT 10")
    fun getResumeDetails() : LiveData<Resume>
}