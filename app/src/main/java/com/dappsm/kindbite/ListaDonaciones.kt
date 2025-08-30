package com.dappsm.kindbite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.dappsm.kindbite.navigation.AppNavigation
import com.dappsm.kindbite.ui.theme.KindBiteTheme

class ListaDonaciones : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KindBiteTheme {

            }
        }
    }
}
@Composable
fun MostrarLD(){
    Text("Lista de donaciones")
}