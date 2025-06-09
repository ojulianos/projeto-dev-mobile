package com.example.gwsapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.gwsapp.data.model.Usuario
import com.example.gwsapp.ui.components.CadastroUsuarioForm
import com.example.gwsapp.ui.components.UsuarioItem
import com.example.gwsapp.ui.viewmodel.UsuarioViewModel

@Composable
fun UsuariosScreen(navController: NavHostController, viewModel: UsuarioViewModel) {
    var showForm by remember { mutableStateOf(false) }
    var selectedUser by remember { mutableStateOf<Usuario?>(null) }
    val usuarios = viewModel.usuarios.value

    LaunchedEffect(Unit) { viewModel.loadUsuarios() }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Button(onClick = { selectedUser = null; showForm = true }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Cadastrar Usuário")
        }

        if (showForm) {
            CadastroUsuarioForm(
                usuario = selectedUser,
                onClose = { showForm = false },
                onSave = { novoUsuario ->
                    if (selectedUser == null) {
                        viewModel.createUsuario(novoUsuario)
                    } else {
                        viewModel.updateUsuario(selectedUser!!._id, novoUsuario)
                    }
                    showForm = false
                }
            )
        } else {
            LazyColumn {
                items(usuarios) { usuario ->
                    UsuarioItem(
                        usuario = usuario,
                        onEdit = {
                            selectedUser = usuario
                            showForm = true
                        },
                        onDelete = { viewModel.deleteUsuario(usuario._id) }
                    )
                }
            }
        }
    }
}
