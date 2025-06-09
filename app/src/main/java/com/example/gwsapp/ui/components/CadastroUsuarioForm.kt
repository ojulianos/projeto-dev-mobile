package com.example.gwsapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gwsapp.data.model.Usuario

@Composable
fun CadastroUsuarioForm(usuario: Usuario?, onClose: () -> Unit, onSave: (Usuario) -> Unit) {
    var nome by remember { mutableStateOf(usuario?.nome ?: "") }
    var email by remember { mutableStateOf(usuario?.email ?: "") }
    var dataNascimento by remember { mutableStateOf(usuario?.dataNascimento ?: "") }
    var senha by remember { mutableStateOf(usuario?.senha ?: "") }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = if (usuario == null) "Cadastro de Usuário" else "Editar Usuário", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = nome, onValueChange = { nome = it }, label = { Text("Nome") })
        OutlinedTextField(value = email, onValueChange = { email = it }, label = { Text("Email") })
        OutlinedTextField(value = dataNascimento, onValueChange = { dataNascimento = it }, label = { Text("Data de Nascimento") })
        OutlinedTextField(value = senha, onValueChange = { senha = it }, label = { Text("Senha") })

        Spacer(modifier = Modifier.height(16.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Button(onClick = { onClose() }) {
                Text(text = "Voltar")
            }
            Button(onClick = { onSave(Usuario(usuario?._id ?: "", nome, email, dataNascimento, senha, usuario?._id ?: "")) }) {
                Text(text = if (usuario == null) "Salvar" else "Atualizar")
            }
        }
    }
}
