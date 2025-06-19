package com.example.gwsapp.utils

import com.google.firebase.auth.FirebaseAuth


object Auth {
    fun login(email: String, password: String, onResult: (Boolean) -> Unit) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                onResult(task.isSuccessful)
            }
    }

    fun register(email: String, password: String, onResult: (Boolean) -> Unit) {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                onResult(task.isSuccessful)
            }
    }

    fun resetPassword(email: String, onResult: (Boolean) -> Unit) {
        FirebaseAuth.getInstance().sendPasswordResetEmail(email)
            .addOnCompleteListener { task ->
                onResult(task.isSuccessful)
            }
    }

    fun logout() {
        FirebaseAuth.getInstance().signOut()
    }
}