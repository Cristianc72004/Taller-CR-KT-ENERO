package com.example.taller_crbekevtienero

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.NavType
import com.example.taller_crbekevtienero.Pantallas.ParamScreen
import com.example.taller_crbekevtienero.Pantallas.UserLits
import com.example.taller_crbekevtienero.Pantallas.CheckBoxScreen
import com.example.taller_crbekevtienero.Pantallas.HomePlace

@Composable
fun NavigatioHostController() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {

        composable(route = "home") {
            HomePlace(navController)
        }

        composable(route = "listaUsuarios") {
            ParamScreen(navController)
        }

        composable(route = "listado"){
            CheckBoxScreen(navController)
        }

        composable(
            route = "Userlista/{nombre}/{iconName}/{rowIconName}",
            arguments = listOf(
                navArgument("nombre") { type = NavType.StringType },
                navArgument("iconName") { type = NavType.StringType },
                navArgument("rowIconName") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val nombre = backStackEntry.arguments?.getString("nombre") ?: "Usuario"
            val iconName = backStackEntry.arguments?.getString("iconName") ?: "Person"
            val rowIconName = backStackEntry.arguments?.getString("rowIconName") ?: "Edit"

            UserLits(navController = navController, nombre = nombre, iconName = iconName, rowIconName = rowIconName)
        }
    }
}
