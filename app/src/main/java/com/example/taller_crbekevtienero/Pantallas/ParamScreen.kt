package com.example.taller_crbekevtienero.Pantallas

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.taller_crbekevtienero.funciones.ItemParam

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ParamScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Lista de Usuarios") },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Volver",
                        modifier = Modifier.clickable { navController.popBackStack() }
                    )
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Lista de Usuarios con iconos personalizados
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                ItemParam(
                    nombre = "Luis Perez", iconName = "Person", rowIconName = "Edit", onEditClick = { /* Acción al editar */ },
                    onCallClick = { nombre, iconName, rowIconName -> navController.navigate("Userlista/$nombre/$iconName/$rowIconName")
                    }
                )

                ItemParam(
                    nombre = "Cristian Benalcazar", iconName = "Person", rowIconName = "Edit", onEditClick = { /* Acción al editar */ },
                    onCallClick = { nombre, iconName, rowIconName -> navController.navigate("Userlista/$nombre/$iconName/$rowIconName")
                    }
                )


                ItemParam(
                    nombre = "Kevin tirira", iconName = "Person", rowIconName = "Edit", onEditClick = { /* Acción al editar */ },
                    onCallClick = { nombre, iconName, rowIconName -> navController.navigate("Userlista/$nombre/$iconName/$rowIconName")
                    }
                )

                ItemParam(nombre = "Mario Cajas", iconName = "Person", rowIconName = "Work", onEditClick = { /* Acción al editar */ },
                    onCallClick = { nombre, iconName, rowIconName -> navController.navigate("Userlista/$nombre/$iconName/$rowIconName")
                    }
                )

                ItemParam(
                    nombre = "Fernando Arteaga", iconName = "Person", rowIconName = "Work",
                    onEditClick = { /* Acción al editar */ }, onCallClick = { nombre, iconName, rowIconName ->
                        navController.navigate("Userlista/$nombre/$iconName/$rowIconName")
                    }
                )

                ItemParam(
                    nombre = "Victor Sisa", iconName = "Person", rowIconName = "Work",
                    onEditClick = { /* Acción al editar */ }, onCallClick = { nombre, iconName, rowIconName ->
                        navController.navigate("Userlista/$nombre/$iconName/$rowIconName")
                    }
                )
            }

            // Botón de regreso personalizado
            OutlinedButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier.padding(16.dp).width(200.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.White, // Fondo blanco
                    contentColor = Color(0xFF800080) // Letras moradas (Color Púrpura)
                ),
                border = BorderStroke(1.dp, Color.Gray) // Borde gris correcto
            ) {
                Text("Regresar")
            }
        }
    }
}
