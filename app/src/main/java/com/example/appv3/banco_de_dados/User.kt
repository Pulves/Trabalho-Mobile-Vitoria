package com.example.appv3.banco_de_dados

import androidx.room.Database
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.RoomDatabase
@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    val username: String,
    val email: String,
    val passwd: String)