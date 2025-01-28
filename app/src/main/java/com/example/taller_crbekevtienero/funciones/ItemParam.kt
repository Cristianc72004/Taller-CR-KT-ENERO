package com.example.taller_crbekevtienero.funciones

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ItemParam(
    nombre: String,
    iconName: String, // Nombre del icono principal que se mostrará en UserLits
    rowIconName: String, // Icono que se mostrará en la lista
    onEditClick: () -> Unit,
    onCallClick: (String, String, String) -> Unit, // Se pasan ambos iconos
    modifier: Modifier = Modifier
) {

    val rowIcon = when (rowIconName) {
        "Edit" -> Icons.Default.Edit
        "Work" -> Icons.Default.Bathtub
        else -> Icons.Default.Person
    }

    val rowIconColor = when (rowIconName) {
        "Edit" -> Color.Green  // Edit en verde
        "Work" -> Color.Black  // Bathtub en negro
        else -> MaterialTheme.colorScheme.primary
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = rowIcon, // Usa el icono de la fila
                contentDescription = "User Row Icon",
                modifier = Modifier.size(24.dp),
                tint = rowIconColor // Aplica el color según el icono
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = nombre,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Row {
            IconButton(onClick = { onCallClick(nombre, iconName, rowIconName) }) { // Pasa los iconos como Strings
                Icon(
                    imageVector = Icons.Default.Call,
                    contentDescription = "Call Icon",
                    tint = MaterialTheme.colorScheme.tertiary
                )
            }
        }
    }
}
