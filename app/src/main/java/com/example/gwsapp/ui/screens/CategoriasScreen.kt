package com.example.gwsapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.gwsapp.ui.viewmodel.UsuarioViewModel

@Composable
fun CategoriasScreen(navController: NavHostController, s: UsuarioViewModel) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Text(text = "Categorias", style = MaterialTheme.typography.bodyLarge)
        LazyColumn {
            items(10) { index ->
                Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                    Text(text = "Categoria ${index + 1}", modifier = Modifier.padding(16.dp))
                }
            }
        }
    }
}
