package com.dappsm.kindbite

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.dappsm.kindbite.navigation.AppScreens
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController){
    LaunchedEffect(key1=true) {
        delay(2500)
        navController.popBackStack()
        navController.navigate(AppScreens.Login.route)
    }
    PantallaInicio()
}
@Composable
fun PantallaInicio(modifier: Modifier=Modifier){
    Column(modifier = Modifier.fillMaxSize().background(Color(0xFFFDF9ED)),  verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
        Row (horizontalArrangement = Arrangement.Center,verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth())
        {
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = null,
                modifier=Modifier.size(230.dp)
            )
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MPI(){
    PantallaInicio()
}
