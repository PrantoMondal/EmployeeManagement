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
    var user: FirebaseUser? = fireAuth.currentUser

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

    fun login(email:String,password:String){
        fireAuth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener{
                if (it.isSuccessful){
                    authLD.value = Auth.AUTHENTICATED
                    user = fireAuth.currentUser
                }
            }
            .addOnFailureListener{
                errorMsgLD.value = it.localizedMessage
            }
    }
    fun logout(){
        if (user != null){
            fireAuth.signOut()
            authLD.value = Auth.UNAUTHENTICATED
        }
    }



}