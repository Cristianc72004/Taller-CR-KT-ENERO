package com.example.taller_crbekevtienero.funciones

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.clickable
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text


@Composable
fun CheckBoxOption(
    text: String,
    checkedValue: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(16.dp).clickable {
            onCheckedChange(!checkedValue)
        }
    ) {
        Checkbox(
            checked = checkedValue,
            onCheckedChange = onCheckedChange
        )
        Text(text = text)
    }
}

@Composable
fun CheckBoxOptions(
    onOption1Change: (Boolean) -> Unit,
    onOption2Change: (Boolean) -> Unit,
    onOption3Change: (Boolean) -> Unit,
    onOption4Change: (Boolean) -> Unit,
    onOption5Change: (Boolean) -> Unit
) {
    var checkedValue1 by remember { mutableStateOf(false) }
    var checkedValue2 by remember { mutableStateOf(false) }
    var checkedValue3 by remember { mutableStateOf(false) }
    var checkedValue4 by remember { mutableStateOf(false) }
    var checkedValue5 by remember { mutableStateOf(false) }


    Column {
        CheckBoxOption(
            text = "Seco de pollo",
            checkedValue = checkedValue1,
            onCheckedChange = {
                checkedValue1 = it
                onOption1Change(it)
            }
        )


        CheckBoxOption(
            text = "Seco de carne",
            checkedValue = checkedValue2,
            onCheckedChange = {
                checkedValue2 = it
                onOption2Change(it)
            }
        )
        CheckBoxOption(
            text = "Tilapia Asada",
            checkedValue = checkedValue3,
            onCheckedChange = {
                checkedValue3 = it
                onOption3Change(it)
            }
        )
        CheckBoxOption(
            text = "Maito de pesacado",
            checkedValue = checkedValue4,
            onCheckedChange = {
                checkedValue4 = it
                onOption4Change(it)
            }
        )
        CheckBoxOption(
            text = "Guanta al Horno",
            checkedValue = checkedValue5,
            onCheckedChange = {
                checkedValue5 = it
                onOption5Change(it)
            }
        )
    }
}



