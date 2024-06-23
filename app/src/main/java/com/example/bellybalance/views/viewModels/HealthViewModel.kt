package com.example.bellybalance.views.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bellybalance.db.HealthDataDao
import com.example.bellybalance.db.HealthData
import kotlinx.coroutines.launch

//Not implemented in ui pages because of lake of time

class HealthViewModel(
    private val userViewModel: UserViewModel,
    private val healthDataDao: HealthDataDao
) : ViewModel() {

    fun addHealthData(food: String, conditions: String, foodTime: String, poopTime: String, poopType: String) {
        userViewModel.currentUser?.let { user ->
            viewModelScope.launch {
                val healthData = HealthData(
                    userId = user.id,
                    food = food,
                    conditions = conditions,
                    foodTime = foodTime,
                    poopTime = poopTime,
                    poopType = poopType
                )
                healthDataDao.addHealthData(healthData)
            }
        }
    }

    fun getHealthDataForUser(): LiveData<List<HealthData>> {
        return userViewModel.currentUser?.let { user ->
            healthDataDao.getHealthDataForUser(user.id)
        } ?: MutableLiveData(emptyList())
    }
}
