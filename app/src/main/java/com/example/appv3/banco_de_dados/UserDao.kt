package com.example.appv3.banco_de_dados

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {

    @Insert
    fun insert(user: User)

    @Query("SELECT * FROM user_table")
    fun getAll(): LiveData<List<User>>

    @Query("SELECT * FROM user_table WHERE username = :username")
    fun get(username: String): LiveData<User>

    @Update
    fun update(user: User)

    @Delete
    fun delete(user: User)
}