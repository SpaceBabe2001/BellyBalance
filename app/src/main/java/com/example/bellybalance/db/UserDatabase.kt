package com.example.bellybalance.db

import com.example.bellybalance.views.User
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(entities = [User::class], version =1)
@TypeConverters(Converters::class)
abstract class BellyBalanceDatabase : RoomDatabase(){

    companion object {
        const val NAME = "BellyBalance_DB"
    }

    abstract fun getUserDao() : UserDao

}