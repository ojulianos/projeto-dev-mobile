package com.example.gwsapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gwsapp.utils.Constants

@Composable
fun DrawerContent(onItemSelected: (String, String) -> Unit) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Constants.MENU_ITEMS.forEach { (route, title) ->
            Button(onClick = { onItemSelected(route, title) }, modifier = Modifier.fillMaxWidth()) {
                Text(text = title)
            }
        }
        Button(onClick = { onItemSelected("sair", "Saindo...") }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Sair")
        }
    }
}
