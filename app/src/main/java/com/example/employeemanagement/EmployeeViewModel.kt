package com.example.employeemanagement

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class EmployeeViewModel:ViewModel() {
    enum class Auth{
        AUTHENTICATED, UNAUTHENTICATED
    }
    val fireAuth = FirebaseAuth.getInstance()
    val user: FirebaseUser? = fireAuth.currentUser

    val authLD : MutableLiveData<Auth> = MutableLiveData()
    val errorMsgLD : MutableLiveData<String> = MutableLiveData()

    init {
        if (user != null){
           authLD.value = Auth.AUTHENTICATED
        }
        else{
            authLD.value = Auth.UNAUTHENTICATED
        }
    }


}