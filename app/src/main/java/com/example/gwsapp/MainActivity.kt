package com.example.gwsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gwsapp.data.factory.UsuarioViewModelFactory
import com.example.gwsapp.data.repository.UsuarioRepository
import com.example.gwsapp.ui.theme.GWSAppTheme
import com.example.gwsapp.ui.viewmodel.UsuarioViewModel
import com.example.gwsapp.ui.components.AppContent
import com.example.gwsapp.ui.screens.LoginScreen
import com.google.firebase.auth.FirebaseAuth


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val usuarioRepository = UsuarioRepository()
        val usuarioViewModel = ViewModelProvider(this, UsuarioViewModelFactory(usuarioRepository))[UsuarioViewModel::class.java]

        setContent {

            val navController = rememberNavController()
            val currentUser = FirebaseAuth.getInstance().currentUser

            LaunchedEffect(currentUser) {
                if (currentUser != null) {
                    navController.navigate("app") {
                        popUpTo("login") { inclusive = true }
                    }
                }
            }

            NavHost(navController, startDestination = if (currentUser != null) "app" else "login") {
                composable("login") {
                    LoginScreen(onLoginSuccess = {
                        navController.navigate("app") {
                            popUpTo("login") { inclusive = true }
                        }
                    })
                }
                composable("app") {
                    AppContent(usuarioViewModel)
                }
            }
        }
    }
}
