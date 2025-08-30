package com.dappsm.kindbite.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dappsm.kindbite.LoginViewModel
import com.dappsm.kindbite.MainActivity
import com.dappsm.kindbite.MostrarIS
import com.dappsm.kindbite.MostrarLD
import com.dappsm.kindbite.MostrarMainScreen
import com.dappsm.kindbite.SplashScreen

@Composable
fun AppNavigation(){
    val navController=rememberNavController()
    NavHost(
        navController=navController,
        startDestination= AppScreens.SplashScreen.route){
        composable(AppScreens.SplashScreen.route){
            SplashScreen(navController)
        }
        composable(AppScreens.Login.route){
            MostrarIS(navController)
        }
        composable(AppScreens.MainScreen.route){
            MostrarMainScreen()
        }
    }
}