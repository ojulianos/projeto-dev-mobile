package com.example.gwsapp.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gwsapp.data.model.Categoria
import com.example.gwsapp.data.repository.CategoriaRepository
import kotlinx.coroutines.launch

class CategoriaViewModel(private val repository: CategoriaRepository): ViewModel() {
    val categoria = mutableStateOf<List<Categoria>>(emptyList())

    fun loadCategoria() {
        viewModelScope.launch {
            repository.getCategoria { categoria.value = it ?: emptyList() }
        }
    }

    fun createCategoria(categoria: Categoria) {
        viewModelScope.launch {
            repository.createCategoria(categoria) {loadCategoria()}
        }
    }

    fun updateCategoria(id: Int, categoria: Categoria) {
        viewModelScope.launch {
            repository.updateCategoria(id, categoria) {loadCategoria()}
        }
    }

    fun deleteCategoria(id: Int){
        viewModelScope.launch {
            repository.deleteCategoria(id) { success ->
                if (success) loadCategoria()
            }
        }
    }
}