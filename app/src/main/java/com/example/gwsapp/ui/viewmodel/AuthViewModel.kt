package com.example.gwsapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AuthViewModel : ViewModel() {
    private val _user = MutableStateFlow<FirebaseUser?>(FirebaseAuth.getInstance().currentUser)
    val user: StateFlow<FirebaseUser?> = _user

    init {
        FirebaseAuth.getInstance().addAuthStateListener { _user.value = it.currentUser }
    }
}