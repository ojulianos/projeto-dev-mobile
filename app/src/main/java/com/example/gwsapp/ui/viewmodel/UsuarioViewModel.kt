package com.example.gwsapp.ui.viewmodel


import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gwsapp.data.model.Usuario
import com.example.gwsapp.data.repository.UsuarioRepository
import kotlinx.coroutines.launch

class UsuarioViewModel(private val repository: UsuarioRepository) : ViewModel() {
    var usuarios = mutableStateOf<List<Usuario>>(emptyList())

    fun loadUsuarios() {
        viewModelScope.launch {
            repository.getUsuarios { usuarios.value = it ?: emptyList() }
        }
    }

    fun createUsuario(usuario: Usuario) {
        viewModelScope.launch {
            repository.createUsuario(usuario) { loadUsuarios() }
        }
    }

    fun updateUsuario(id: Int, usuario: Usuario) {
        viewModelScope.launch {
            repository.updateUsuario(id, usuario) { loadUsuarios() }
        }
    }

    fun deleteUsuario(id: Int) {
        viewModelScope.launch {
            repository.deleteUsuario(id) { success ->
                if (success) loadUsuarios()
            }
        }
    }
}