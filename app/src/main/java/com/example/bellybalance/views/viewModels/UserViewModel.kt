package com.example.bellybalance.views.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bellybalance.views.MainApplication
import com.example.bellybalance.db.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {

    val userDao = MainApplication.bellyBalanceDatabase.getUserDao()
    val userList : LiveData<List<User>> = userDao.getAllUser()
    var currentUser: User? = null

    fun getUser(email: String, password: String, onResult: (User?) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
           val user = userDao.getUser(email, password)
            currentUser = user // Store the user information
            onResult(user)
        }
    }

    fun addUser(name : String, email:String, password:String, appversion:String,notification:Boolean){
        viewModelScope.launch(Dispatchers.IO) {
            userDao.addUser(User(name = name, email = email, password = password, appversion = appversion, notification = notification))
        }
    }

    fun deleteUser(id : Int){
        viewModelScope.launch(Dispatchers.IO) {
            userDao.deleteUser(id)
        }
    }


}