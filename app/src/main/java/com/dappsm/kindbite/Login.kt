package com.dappsm.kindbite

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.ui.platform.LocalContext
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.dappsm.kindbite.navigation.AppNavigation
import com.dappsm.kindbite.ui.theme.KindBiteTheme

class Login : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KindBiteTheme {
                AppNavigation()
            }
        }
    }
}




@Composable
fun MostrarIS(nC: NavController){
    IniciaSesion(navController=nC)

}
@Composable
fun IniciaSesion(modifier: Modifier=Modifier,navController: NavController){
    var inputN by rememberSaveable{mutableStateOf("")}
    var inputC by rememberSaveable{mutableStateOf("")}
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize().background(Color(0xFFFDF9ED)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Column(modifier = Modifier.width(320.dp), verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally){
            Text("Bienvenido", fontSize = 20.sp,fontWeight= FontWeight.W200)
            Spacer(modifier = Modifier.size(10.dp))
            Text(text="INICIA SESIÓN", fontWeight= FontWeight.Bold, fontSize = 25.sp,color=Color(0xFFFC8D3F))
            Spacer(modifier=Modifier.size(30.dp))
            Column(){
                Text("Nombre de usuario:", fontSize = 20.sp,color=Color(0xFFFC8D3F))
                Spacer(modifier = Modifier.size(7.dp))
                OutlinedTextField(
                    value = inputN,
                    onValueChange = { inputN= it },
                    modifier = Modifier.fillMaxWidth().height(60.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFFFC8D3F),
                        unfocusedBorderColor = Color(0xFFFC8D3F),
                        focusedContainerColor = Color(0xFFFDF9ED),
                        unfocusedContainerColor = Color(0xFFFDF9ED)

                    ))
                Spacer(modifier = Modifier.size(15.dp))
                Text("Contraseña:",fontSize = 20.sp,color=Color(0xFFFC8D3F))
                Spacer(modifier = Modifier.size(7.dp))
                OutlinedTextField(
                    value = inputC,
                    onValueChange = { inputC= it },
                    modifier = Modifier.fillMaxWidth().height(60.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFFFC8D3F),
                        unfocusedBorderColor = Color(0xFFFC8D3F),
                        focusedContainerColor = Color(0xFFFDF9ED),
                        unfocusedContainerColor = Color(0xFFFDF9ED)

                    )
                )
            }
            Spacer(modifier = Modifier.size(35.dp))
            Button(onClick={
                val resultadoAcceso=compararUsuarios(inputN,inputC,navController)
                if (resultadoAcceso==true){
                    Toast.makeText(context, "Has iniciado sesión correctamente", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(context, "Usuario o contraseña incorrectos.", Toast.LENGTH_SHORT).show()
                }
            },shape = RoundedCornerShape(5.dp),modifier=Modifier.fillMaxWidth().height(35.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFC8D3F)
                )){
                Text("Iniciar Sesión",fontSize = 18.sp,fontWeight=FontWeight.W400)
            }
        }
    }
}

