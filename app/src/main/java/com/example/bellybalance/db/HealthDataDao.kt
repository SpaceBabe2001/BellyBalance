package com.example.bellybalance.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface HealthDataDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addHealthData(healthData: HealthData)

    @Query("SELECT * FROM HealthData WHERE userId = :userId")
    fun getHealthDataForUser(userId: Int): LiveData<List<HealthData>>
}
