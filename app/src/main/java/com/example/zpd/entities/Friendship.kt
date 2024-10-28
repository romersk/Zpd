package com.example.zpd.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.zpd.config.DateConverter
import java.util.Date

@Entity
data class Friendship(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val userId1: Long,
    val userId2: Long,
    @TypeConverters(DateConverter::class) var requestdate: Date,
    @TypeConverters(DateConverter::class) var approvedDate: Date?,
    @TypeConverters(DateConverter::class) var deniedDate: Date?,
    @TypeConverters(DateConverter::class) var terminationDate: Date?
)
