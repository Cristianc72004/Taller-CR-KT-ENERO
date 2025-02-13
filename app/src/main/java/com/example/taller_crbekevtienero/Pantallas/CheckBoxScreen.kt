package com.example.taller_crbekevtienero.Pantallas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.taller_crbekevtienero.funciones.CheckBoxOptions

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun CheckBoxScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Go to back"
                        )
                    }
                },
                title = { Text(text = "Lista de platos") }
            )
        }

    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 66.dp) // Reservamos espacio en la parte inferior para el botón
            ) {
                CheckBoxOptions(
                    onOption1Change = { isChecked -> },
                    onOption2Change = { isChecked ->  },
                    onOption3Change = { isChecked ->  },
                    onOption4Change = { isChecked ->  },
                    onOption5Change = { isChecked ->  }
                )
            }

            ElevatedButton(
                enabled = true,
                onClick = { navController.popBackStack() },
                modifier = Modifier
                    .align(Alignment.BottomCenter) // Centrado y en la parte inferior
                    .padding(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray) // Botón de color gris claro
            ) {
                Text(text = "Regresar", color = Color.Black)
            }

        }
    }
}