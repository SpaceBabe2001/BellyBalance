package com.example.bellybalance.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(entities = [User::class, HealthData::class], version =2)
@TypeConverters(Converters::class)
abstract class BellyBalanceDatabase : RoomDatabase(){

    companion object {
        const val NAME = "BellyBalance_DB"
    }

    abstract fun getUserDao() : UserDao
    //abstract fun getHealthData() : HealthDataDao
    //HealthData::class -> should be added to entities
}