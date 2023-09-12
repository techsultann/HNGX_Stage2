package com.techsultan.hngxstage2.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.net.URL

@Entity(tableName = "resume")
data class Resume(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val slack: String,
    val twitter: String,
    val linkedin: String,
    val instagram : String,
    val github: String
)
