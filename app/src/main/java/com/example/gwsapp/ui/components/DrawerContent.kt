package com.example.gwsapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gwsapp.utils.Auth
import com.example.gwsapp.utils.Constants

@Composable
fun DrawerContent(onItemSelected: (String, String) -> Unit) {
    Text("GWS App", modifier = Modifier.padding(16.dp))
    Row (
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(text = "---------------")
    }
    Constants.MENU_ITEMS.forEach { (route, title) ->
        NavigationDrawerItem(
            label = { Text(text = title) },
            selected = false,
            onClick = { onItemSelected(route, title) }
        )
    }
    NavigationDrawerItem(
        label = { Text(text = "Sair") },
        selected = false,
        onClick = { Auth.logout(); }
    )
}
