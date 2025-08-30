package com.dappsm.kindbite.navigation

sealed class AppScreens (val route:String) {
    object SplashScreen: AppScreens("SplashScreen")
    object Login: AppScreens("Login")

    object MainScreen: AppScreens("MainScreen")

}