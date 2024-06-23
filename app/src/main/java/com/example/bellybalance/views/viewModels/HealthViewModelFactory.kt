package com.example.bellybalance.views.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bellybalance.db.HealthDataDao

class HealthViewModelFactory(
    private val userViewModel: UserViewModel,
    private val healthDataDao: HealthDataDao
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HealthViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HealthViewModel(userViewModel, healthDataDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
