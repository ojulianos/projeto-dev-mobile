package com.example.gwsapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gwsapp.data.model.Categoria

@Composable
fun CadastroCategoriaForm(categoria: Categoria?, onClose: () -> Unit, onSave: (Categoria) -> Unit) {
    var nome by remember { mutableStateOf(categoria?.nome ?: "") }
    var descricao by remember { mutableStateOf(categoria?.descricao ?: "") }
    var idadeMin by remember { mutableStateOf(categoria?.idadeMin ?: 0) }
    var idadeMax by remember { mutableStateOf(categoria?.idadeMax ?: 0) }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = if (categoria == null) "Cadastro de Categoria" else "Editar Categoria", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = nome, onValueChange = { nome = it }, label = { Text("Nome") })
        OutlinedTextField(value = descricao, onValueChange = { descricao = it }, label = { Text("Descrição") })
        OutlinedTextField(value = idadeMin.toString(), onValueChange = { idadeMin = it.toIntOrNull()?: 0}, label = { Text("Idade Mínima") })
        OutlinedTextField(value = idadeMax.toString(), onValueChange = { idadeMax = it.toIntOrNull()?: 0}, label = { Text("Idade Máxima") })

        Spacer(modifier = Modifier.height(16.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Button(onClick = { onClose() }) {
                Text(text = "Voltar")
            }
            Button(onClick = { onSave(Categoria(categoria?.id ?: "", nome, descricao, idadeMin, idadeMax)) }) {
                Text(text = if (categoria == null) "Salvar" else "Atualizar")
            }
        }
    }
}