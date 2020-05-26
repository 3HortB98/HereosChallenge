package com.example.superheroeschallenge

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = TABLE_NAME)
data class Heroes (
    @PrimaryKey(autoGenerate = true) val id: Int,
    val Name: String,
    val Picture: String,
    val Score: Int

)