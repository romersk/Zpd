package com.example.zpd.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.zpd.config.DateConverter
import java.util.Date

@Entity(
    tableName = "animal",
    foreignKeys = [ForeignKey(
        entity = User::class,
        parentColumns = ["id"],
        childColumns = ["user_iduser"],
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE
    )]
)
data class Animal(
    @PrimaryKey(autoGenerate = true) var idanimal: Long,
    var user_iduser: Long,
    var name: String,
    var type: String,
    var breed: String,
    @TypeConverters(DateConverter::class)  var birthdate: Date?,
    var behavior: String? = null
)
