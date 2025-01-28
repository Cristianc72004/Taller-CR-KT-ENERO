package com.example.taller_crbekevtienero.Pantallas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserLits(navController: NavHostController, nombre: String, iconName: String, rowIconName: String) {
    val mainIcon: ImageVector = when (iconName) {
        "Person" -> Icons.Default.Face
        else -> Icons.Default.Person
    }

    val rowIcon: ImageVector = when (rowIconName) {
        "Edit" -> Icons.Default.Edit
        "Work" -> Icons.Default.Bathtub
        else -> Icons.Default.Person
    }

    val rowIconColor = when (rowIconName) {
        "Edit" -> Color.Green
        "Work" -> Color.Black
        else -> MaterialTheme.colorScheme.primary
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Parámetros") },
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
            verticalArrangement = Arrangement.SpaceBetween, // Separa el contenido y el botón abajo
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Icono principal en la parte superior
                Icon(
                    imageVector = mainIcon,
                    contentDescription = "Icono de usuario",
                    modifier = Modifier.size(80.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))

                // Nombre con icono de fila
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = rowIcon, // Icono de la fila
                        contentDescription = "User Icon",
                        modifier = Modifier.size(24.dp),
                        tint = rowIconColor // Se aplica el color correcto
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = nombre,
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        imageVector = Icons.Default.Call,
                        contentDescription = "Llamar",
                        modifier = Modifier.size(24.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }

            // Botón de regresar al Home
            OutlinedButton(
                onClick = { navController.navigate("home") },
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .height(50.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.Gray, // Fondo gris
                    contentColor = Color.Black  // Texto negro
                )// Borde negro
            ) {
                Text(text = "Regresar", color = Color.Black)
            }
        }
    }
}
