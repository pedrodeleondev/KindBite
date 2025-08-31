package com.dappsm.kindbite

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.dappsm.kindbite.ui.theme.KindBiteTheme

class CUDonaciones : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KindBiteTheme {
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun barraLateralTop(navController: NavController){
    val context = LocalContext.current
    Scaffold(modifier = Modifier.padding(5.dp),
        topBar = {
            TopAppBar(
                title = {},
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFFDF9ED),
                    titleContentColor = Color(0xFFFC8D3F),
                ),
                actions = {
                    IconButton(onClick = {
                        if(Sesion.usuarioActual?.tipoUsuario=="admin"){
                            navController.navigate("AdminUsuarios")
                        }else{
                            Toast.makeText(context, "No tienes permiso para entrar a esta ventana", Toast.LENGTH_SHORT).show()
                        }
                    }) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.admin),
                            contentDescription = "",
                            tint = Color(0xFFFC8D3F)
                        )
                    }
                }
            )
        },
        content = { innerPadding ->
            CUDonacion(innerPadding)
        }
    )
}

@Composable
fun CUDonacion(innerPaddingValues: PaddingValues){
    var ID by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var alimento by remember { mutableStateOf("") }
    var cantidad by remember { mutableStateOf("") }
    var dateDonacion by remember { mutableStateOf("") }
    val context = LocalContext.current


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFDF9ED))
            .padding(12.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Text("Agregar/Editar donaciones",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 72.dp, bottom = 4.dp),
            style =
                TextStyle(
                    fontSize = 24.sp,
                    color = Color(0xFFFC8D3F),
                    fontWeight = FontWeight.ExtraBold)
        )
        Text("Agrega una donación",
            modifier = Modifier
                .fillMaxWidth(),
            style =
                TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraLight)
        )
        Spacer(modifier=Modifier.padding(top = 12.dp))
        Text("ID:", fontSize = 15.sp,color=Color(0xFFFC8D3F))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = ID,
            onValueChange = { ID = it },
            label = {
                Text("Al dar click se autocompletará",
                    color=Color(0xFF7E7B7B), fontWeight = FontWeight.Light)
            },
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFFFC8D3F),
                unfocusedBorderColor = Color(0xFFFC8D3F),
                focusedContainerColor = Color(0xFFFDF9ED),
                unfocusedContainerColor = Color(0xFFFDF9ED)
            )
        )

        Spacer(modifier=Modifier.padding(top = 20.dp))
        Text("Nombre:", fontSize = 15.sp,color=Color(0xFFFC8D3F))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = name,
            onValueChange = {name = it},
            label = { Text("ej. Pablo Hernandez",
                color=Color(0xFF7E7B7B), fontWeight = FontWeight.Light)
            },
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFFFC8D3F),
                unfocusedBorderColor = Color(0xFFFC8D3F),
                focusedContainerColor = Color(0xFFFDF9ED),
                unfocusedContainerColor = Color(0xFFFDF9ED)
            )
        )

        Spacer(modifier=Modifier.padding(top = 20.dp))
        Text("Alimento a donar", fontSize = 15.sp,color=Color(0xFFFC8D3F))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = alimento,
            onValueChange = {alimento = it},
            label = { Text("ej. Carne cruda (milanesa)",
                color=Color(0xFF7E7B7B), fontWeight = FontWeight.Light)
            },
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFFFC8D3F),
                unfocusedBorderColor = Color(0xFFFC8D3F),
                focusedContainerColor = Color(0xFFFDF9ED),
                unfocusedContainerColor = Color(0xFFFDF9ED)
            )
        )

        Spacer(modifier=Modifier.padding(top = 20.dp))
        Text("Cantidad:", fontSize = 15.sp,color=Color(0xFFFC8D3F))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = cantidad,
            onValueChange = {cantidad = it},
            label = { Text("ej. 120 kgs",
                color=Color(0xFF7E7B7B), fontWeight = FontWeight.Light)
            },
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFFFC8D3F),
                unfocusedBorderColor = Color(0xFFFC8D3F),
                focusedContainerColor = Color(0xFFFDF9ED),
                unfocusedContainerColor = Color(0xFFFDF9ED)
            )
        )

        Spacer(modifier=Modifier.padding(top = 20.dp))
        Text("Fecha de donación:", fontSize = 15.sp,color=Color(0xFFFC8D3F))
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 2.dp, bottom = 5.dp),
            value = dateDonacion,
            onValueChange = {dateDonacion = it},
            label = { Text("ej. 1/10/25",
                color=Color(0xFF7E7B7B), fontWeight = FontWeight.Light)
            },
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFFFC8D3F),
                unfocusedBorderColor = Color(0xFFFC8D3F),
                focusedContainerColor = Color(0xFFFDF9ED),
                unfocusedContainerColor = Color(0xFFFDF9ED)
            )
        )

        Button(onClick = {
            if(ID == "" && name.isNotEmpty() && alimento.isNotEmpty() && cantidad.isNotEmpty() && dateDonacion.isNotEmpty()){
                val rid = DonacionesRepo.obtenerDonaciones().size + 1
                val nueva = Donacion(rid,name,alimento,cantidad,dateDonacion)
                DonacionesRepo.agregarDonacion(nueva)
            } else if (ID!=""){
                DonacionesRepo.editarDonacion(ID,name,alimento,cantidad,dateDonacion)
            }else{
                Toast.makeText(context, "Llenaste mal un campo o hiciste el procedimiento incorrecto", Toast.LENGTH_SHORT).show()
            }
            ID=""
            name=""
            alimento=""
            cantidad=""
            dateDonacion=""
        },
            shape = RoundedCornerShape(15.dp),
            modifier=Modifier
                .fillMaxWidth()
                .padding(top = 15.dp, bottom = 5.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFC8D3F)
            )){
            Text("Registrar", fontSize = 18.sp, fontWeight = FontWeight.Normal)
        }
    }
}

@Composable
fun MostrarCUD(navController: NavController){
    barraLateralTop(navController)
}
