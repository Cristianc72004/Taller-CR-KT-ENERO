package com.example.taller_crbekevtienero.Pantallas

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePlace(navController: NavHostController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Home") }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Icono Usuario
            Icon(
                imageVector = Icons.Default.Face,
                contentDescription = "User Icon",
                modifier = Modifier.size(80.dp)
            )

            Spacer(modifier = Modifier.height(20.dp)) // Espaciado entre icono y campos

            // Campos de Entrada (Usuario y Contraseña)
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp) // Espaciado uniforme
            ) {
                // Campo Usuario
                var userText by rememberSaveable { mutableStateOf("") }
                OutlinedTextField(
                    value = userText,
                    onValueChange = { userText = it },
                    label = { Text("Usuario") }, // Etiqueta dentro del campo
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    maxLines = 1
                )

                // Campo Password
                var passwordText by rememberSaveable { mutableStateOf("") }
                var showPassword by rememberSaveable { mutableStateOf(false) }

                OutlinedTextField(
                    value = passwordText,
                    onValueChange = { passwordText = it },
                    label = { Text("Password") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    maxLines = 1,
                    visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        IconButton(onClick = { showPassword = !showPassword }) {
                            Icon(
                                imageVector = if (showPassword) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                                contentDescription = "Toggle password visibility"
                            )
                        }
                    }
                )
            }

            Spacer(modifier = Modifier.height(20.dp)) // Espaciado antes de los botones

            // Botones de Navegación
            Button(
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                onClick = { navController.navigate("listaUsuarios") }
            ) {
                Text(text = "Listas de Usuarios", color = Color.Black)
            }

            Button(
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                onClick = { navController.navigate("listado") }
            ) {
                Text(text = "Listado de Platos", color = Color.Black)
            }

            Button(
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                onClick = {
                    navController.navigate("Userlista/Luis Perez/Person/Edit")
                }
            ) {
                Text(text = "Envio Parámetros", color = Color.Black)
            }
        }
    }
}
