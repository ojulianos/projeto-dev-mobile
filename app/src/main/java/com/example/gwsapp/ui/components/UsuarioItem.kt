package com.example.gwsapp.ui.components

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.gwsapp.data.model.Usuario

@Composable
fun UsuarioItem(usuario: Usuario, onEdit: () -> Unit, onDelete: () -> Unit) {
    val context = LocalContext.current

    Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
        Row(modifier = Modifier.padding(16.dp), horizontalArrangement = Arrangement.SpaceBetween) {
            Column(modifier = Modifier.weight(1f).clickable { onEdit() }) {
                Text(text = "Usuário: ${usuario.nome}")
                Text(text = "Email: ${usuario.email}")
            }

            IconButton(onClick = {
                onDelete()
                Toast.makeText(context, "Usuário excluído com sucesso!", Toast.LENGTH_SHORT).show()
            }) {
                Icon(Icons.Default.Delete, contentDescription = "Excluir Usuário")
            }
        }
    }
}
