package com.example.gwsapp.ui.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.gwsapp.R
import com.google.firebase.auth.FirebaseAuth


@Composable
fun LoginScreen(onLoginSuccess: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val auth = FirebaseAuth.getInstance()
    val context = LocalContext.current

    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            Image(
                painter = painterResource(  id = R.drawable.bola),
                contentDescription = "Logo",
                modifier = Modifier.size(100.dp)
            )

            Text(
                text = "Bem Vindo, GWS",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            TextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") }
            )

            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Senha") },
                visualTransformation = PasswordVisualTransformation()
            )

            Button(onClick = {

                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(context, "Login bem-sucedido", Toast.LENGTH_SHORT).show()
                            onLoginSuccess()
                        } else {
                            Toast.makeText(context, "Erro no login", Toast.LENGTH_SHORT).show()
                        }
                    }
            }) {
                Text("Entrar")
            }

            TextButton(onClick = { /* todo */ }) {
                Text("Esqueci minha senha")
            }
        }
    }
}
