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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dappsm.kindbite.ui.theme.KindBiteTheme

class Login : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KindBiteTheme {
                IniciaSesion()
            }
        }
    }
}





@Composable
fun IniciaSesion(modifier: Modifier=Modifier){
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
            Text("Bienvenidos")
            Text("INICIA SESIÓN")
            Column(){
                Text("Nombre:")
                OutlinedTextField(
                    value = inputN,
                    onValueChange = { inputN= it },
                    modifier = Modifier.fillMaxWidth().height(50.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFFFC8D3F),
                        unfocusedBorderColor = Color(0xFFFC8D3F),
                        focusedContainerColor = Color(0xFFFDF9ED),
                        unfocusedContainerColor = Color(0xFFFDF9ED)

                    ))
                Text("Contraseña:")
                OutlinedTextField(
                    value = inputC,
                    onValueChange = { inputC= it },
                    modifier = Modifier.fillMaxWidth().height(50.dp),
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
                val resultadoAcceso=compararUsuarios(inputN,inputC)
                if (resultadoAcceso==true){
                    Toast.makeText(context, "Has iniciado sesión correctamente", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(context, "Usuario o contraseña incorrectos.", Toast.LENGTH_SHORT).show()
                }
            },shape = RoundedCornerShape(5.dp),modifier=Modifier.fillMaxWidth().height(35.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFC8D3F)
                )){
                Text("Iniciar Sesión")
            }
        }
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MostrarIS(){
    IniciaSesion()
}