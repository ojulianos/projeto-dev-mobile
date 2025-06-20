package com.example.gwsapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.gwsapp.data.model.Categoria
import com.example.gwsapp.data.model.Usuario

@Composable
fun CadastroUsuarioForm(usuario: Usuario?, onClose: () -> Unit, onSave: (Usuario) -> Unit) {
    var nome by remember { mutableStateOf(usuario?.nome ?: "") }
    var email by remember { mutableStateOf(usuario?.email ?: "") }
    var dataNascimento by remember { mutableStateOf(usuario?.dataNascimento ?: "") }
    var senha by remember { mutableStateOf(usuario?.senha ?: "") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = if (usuario == null) "Cadastro de Usuário" else "Editar Usuário",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = nome,
            onValueChange = { nome = it },
            label = { Text("Nome") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = dataNascimento,
            onValueChange = { dataNascimento = it },
            label = { Text("Data de Nascimento") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = senha,
            onValueChange = { senha = it },
            label = { Text("Senha") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = { onClose() }) {
                Text(text = "Voltar")
            }
            Button(onClick = {
                onSave(Usuario(usuario?.id ?: "", nome, email, dataNascimento, senha))
            }) {
                Text(text = if (usuario == null) "Salvar" else "Atualizar")
            }
        }
    }

}
