package com.example.gwsapp.ui.components

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.gwsapp.data.model.Categoria

@Composable
fun CategoriaItem(categoria: Categoria, onEdit: () -> Unit, onDelete: () -> Unit) {
    val context = LocalContext.current

    Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
        Row(modifier = Modifier.padding(16.dp), horizontalArrangement = Arrangement.SpaceBetween) {
            Column(modifier = Modifier.weight(1f).clickable { onEdit() }) {
                Text(text = "Categoria: ${categoria.nome}")
                Text(text = "Descrição: ${categoria.descricao}")
            }

            IconButton(onClick = {
                onDelete()
                Toast.makeText(context, "Categoria excluída com sucesso!", Toast.LENGTH_SHORT).show()
            }) {
                Icon(Icons.Default.Delete, contentDescription = "Excluir Categoria")
            }
        }
    }
}