package com.example.bellybalance.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Query("SELECT * FROM User WHERE email = :email AND password = :password")
    suspend fun getUser(email: String, password: String): User?

    @Query("SELECT * FROM User ORDER BY id DESC")
    fun getAllUser(): LiveData<List<User>>

    @Insert
    fun addUser(user : User)

    @Query("Delete FROM User where id = :id")
    fun deleteUser(id : Int)



}