package com.example.bellybalance.views

import android.app.Application
import androidx.room.Room
import com.example.bellybalance.db.BellyBalanceDatabase

class MainApplication : Application() {

    companion object {
        lateinit var bellyBalanceDatabase: BellyBalanceDatabase
            private set // Restrict modification to this class
    }

    override fun onCreate() {
        super.onCreate()

        bellyBalanceDatabase = Room.databaseBuilder(
            applicationContext,
            BellyBalanceDatabase::class.java,
            BellyBalanceDatabase.NAME
        )
            .fallbackToDestructiveMigration() // Example of migration strategy, adjust as needed
            .build()
    }
}
