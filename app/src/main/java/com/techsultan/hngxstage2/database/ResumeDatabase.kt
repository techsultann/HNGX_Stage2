package com.techsultan.hngxstage2.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.techsultan.hngxstage2.model.Resume


@Database(entities = [Resume::class], version = 1)
abstract class ResumeDatabase : RoomDatabase() {

    abstract fun resumeDao() : ResumeDao


    companion object {

        @Volatile
        private var INSTANCE: ResumeDatabase? = null

        fun createDatabase(context: Context) : ResumeDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ResumeDatabase::class.java,
                    "resume_db"
                ).build()

                INSTANCE = instance
                instance
            }
        }


    }


}