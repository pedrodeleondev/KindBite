package com.dappsm.kindbite

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle

@Composable
fun cardUsuarios(){
    val usuarios = usuariosBase()
    LazyColumn (modifier = Modifier.padding(12.dp)) {
        items (usuarios) { usuario ->
            val textId = buildAnnotatedString {
                withStyle(SpanStyle(color = Color(0xFFFC8D3F))){
                    append("Id:")
                }
                withStyle(SpanStyle(color = Color.Black)){
                    append(" ${usuario.id}")
                }
            }
            val textName = buildAnnotatedString {
                withStyle(SpanStyle(color = Color(0xFFFC8D3F))){
                    append("Nombre del usuario:")
                }
                withStyle(SpanStyle(color = Color.Black)){
                    append(" ${usuario.nombre}")
                }
            }
            val textTipoUser = buildAnnotatedString {
                withStyle(SpanStyle(color = Color(0xFFFC8D3F))){
                        append("Tipo de usuario:")
                }
                withStyle(SpanStyle(color = Color.Black)){
                    append(" ${usuario.tipoUsuario}")
                }
            }
            val textCorreo = buildAnnotatedString {
                withStyle(SpanStyle(color = Color(0xFFFC8D3F))){
                    append("Correo:")
                }
                withStyle(SpanStyle(color = Color.Black)){
                    append(" ${usuario.email}")
                }
            }
            val textContrasena = buildAnnotatedString {
                withStyle(SpanStyle(color = Color(0xFFFC8D3F))){
                    append("Contraseña:")
                }
                withStyle(SpanStyle(color = Color.Black)){
                    append(" ${usuario.contrasena}")
                }
            }
            Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFFFDF9ED)),
                shape = RectangleShape,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Text(
                    textId,
                    style = TextStyle(fontSize = 16.sp, color = Color(0xFFFC8D3F), fontWeight = FontWeight.Medium),
                    modifier = Modifier.fillMaxWidth().padding(top = 15.dp)
                )
                Spacer(modifier = Modifier.size(9.dp))
                Text(
                    textName,
                    style = TextStyle(
                        fontSize = 16.sp, color = Color(0xFFFC8D3F), fontWeight = FontWeight.Normal
                    ),
                    modifier = Modifier.fillMaxWidth().padding(top = 3.dp, bottom = 2.dp)
                )
                Text(
                    textTipoUser,
                    style = TextStyle(
                        fontSize = 16.sp, color = Color(0xFFFC8D3F), fontWeight = FontWeight.Normal
                    ),
                    modifier = Modifier.fillMaxWidth().padding(top = 3.dp, bottom = 2.dp)
                )
                Text(
                    textCorreo,
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = Color(0xFFFC8D3F),
                        fontWeight = FontWeight.Normal
                    ),
                    modifier = Modifier.fillMaxWidth().padding(top = 3.dp, bottom = 2.dp)
                )
                Text(
                    textContrasena,
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = Color(0xFFFC8D3F),
                        fontWeight = FontWeight.Normal
                    ),
                    modifier = Modifier.fillMaxWidth().padding(top = 3.dp, bottom = 15.dp)
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun barraTop(){
    Scaffold( modifier = Modifier.padding(5.dp),
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFFDF9ED),
                    titleContentColor = Color(0xFFFC8D3F),
                ),
                navigationIcon = {
                    IconButton(onClick = {navController.popBackStack()}) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "",
                            tint = Color(0xFFFC8D3F)
                        )
                    }
                },
                title = {
                    Text("Administrar usuarios", modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Right,
                        style =
                            TextStyle(
                                fontSize = 25.sp,
                                color = Color(0xFFFC8D3F),
                                fontWeight = FontWeight.ExtraBold)
                    )
                }
            )
        },
        content = { innerPadding ->
            ListaUsuarios(innerPadding)
        }
    )
}

@Composable
fun ListaUsuarios(innerPadding: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFDF9ED))
            .padding(innerPadding),
        verticalArrangement = Arrangement.Top
    ) {
        cardUsuarios()
    }
}


@Composable
fun MostrarAdminUsuarios(){
    barraTop()
}