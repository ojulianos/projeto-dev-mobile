package com.example.gwsapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun DashboardScreen(navController: NavHostController) {
    Row {
        Column {
            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)) {
                Text(text = "Dashboardd 1", modifier = Modifier.padding(16.dp))
            }
        }
        Column {
            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)) {
                Text(text = "Dashboardd 2xxxxx", modifier = Modifier.padding(16.dp))
            }
        }
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        Row {
            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)) {
                Text(text = "Dashboardd 1", modifier = Modifier.padding(16.dp))
            }
            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)) {
                Text(text = "Dashboardd 2", modifier = Modifier.padding(16.dp))
            }
        }
        LazyColumn {
            items(10) { index ->
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)) {
                    Text(text = "Dashboardd ${index + 1}", modifier = Modifier.padding(16.dp))
                }
            }
        }
    }
}
