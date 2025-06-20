package com.example.gwsapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.gwsapp.data.model.Categoria
import com.example.gwsapp.ui.components.CadastroCategoriaForm
import com.example.gwsapp.ui.components.CategoriaItem
import com.example.gwsapp.ui.viewmodel.CategoriaViewModel

@Composable
fun CategoriasScreen(navController: NavHostController, viewModel: CategoriaViewModel) {
    var showForm by remember { mutableStateOf(false) }
    var selectedCategory by remember { mutableStateOf<Categoria?>(null) }
    val categorias = viewModel.categoria.value

    LaunchedEffect(Unit) { viewModel.loadCategoria() }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Button(onClick = { selectedCategory = null; showForm = true }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Cadastrar Categoria")
        }

        if (showForm) {
            CadastroCategoriaForm(
                categoria = selectedCategory,
                onClose = { showForm = false },
                onSave = { novaCategoria ->
                    if (selectedCategory == null) {
                        viewModel.createCategoria(novaCategoria)
                    } else {
                        viewModel.updateCategoria(selectedCategory!!.id, novaCategoria)
                    }
                    showForm = false
                }
            )
        } else {
            LazyColumn {
                items(categorias) { categoria ->
                    CategoriaItem(
                        categoria = categoria,
                        onEdit = {
                            selectedCategory = categoria
                            showForm = true
                        },
                        onDelete = { viewModel.deleteCategoria(categoria.id) }
                    )
                }
            }
        }
    }
}
