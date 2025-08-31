package com.dappsm.kindbite

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dappsm.kindbite.navigation.AppScreens

@Composable
fun CUUsuarioNavigation(){
    val navController=rememberNavController()
    NavHost(
        navController=navController,
        startDestination= CUUsuariosScreen.CUDonaciones.route){
        composable(CUUsuariosScreen.CUDonaciones.route){
            MostrarCUD(navController)
        }
        composable(CUUsuariosScreen.AdminUsuarios.route){
            barraTop(navController)
        }
    }
}