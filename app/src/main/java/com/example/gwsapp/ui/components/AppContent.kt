package com.example.gwsapp.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gwsapp.ui.screens.CategoriasScreen
import com.example.gwsapp.ui.screens.DashboardScreen
import com.example.gwsapp.ui.screens.EventosScreen
import com.example.gwsapp.ui.screens.UsuariosScreen
import com.example.gwsapp.ui.viewmodel.UsuarioViewModel
import com.example.gwsapp.utils.Constants
import kotlinx.coroutines.launch

@Composable
fun AppContent(viewModel: UsuarioViewModel) {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val currentScreenTitle = remember { mutableStateOf("Dashboard") }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                DrawerContent { route, title ->
                    scope.launch { drawerState.close() }
                    navController.navigate(route)
                    currentScreenTitle.value = title
                }
            }
        },
        gesturesEnabled = false
    ) {
        Scaffold(topBar = {
            TopBar(
                title = currentScreenTitle.value,
                drawerState
            )
        }) { paddingValues ->
            Box(modifier = Modifier.padding(paddingValues)) {
                AppNavHost(navController, viewModel)
            }
        }
    }
}

@Composable
fun AppNavHost(navController: NavHostController
   , usuarioViewModel: UsuarioViewModel
) {
    NavHost(
        navController = navController,
        startDestination = "dashboard"
    ) {
        Constants.MENU_ITEMS.forEach { (route, title) ->
            composable(route) {
                when (route) {
                    "dashboard" -> DashboardScreen(navController)
                    "categorias" -> CategoriasScreen(navController, usuarioViewModel)
                    "eventos" -> EventosScreen(navController, usuarioViewModel)
                    "usuarios" -> UsuariosScreen(navController, usuarioViewModel)
                }
            }
        }
    }
}