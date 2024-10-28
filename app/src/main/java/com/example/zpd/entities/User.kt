package com.example.zpd.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.zpd.config.DateConverter
import java.util.Date

@Entity
data class User(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val nickname: String,
    val first_name: String,
    val last_name: String,
    val email: String,
    val profileImageUrl: String?,
    @TypeConverters(DateConverter::class) val birth_day: Date?
)
