package com.dappsm.kindbite

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.activity.ComponentActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.dappsm.kindbite.ui.theme.KindBiteTheme

data class Donaciones(val id:Int, val nameDonante:String, val tipoDonacion:String, val Cantidad:String, val DateDonacion: String, val StatusDonacion:String)

fun donacionesBase():List<Donaciones>{
    return listOf(
        Donaciones(0,"Fernanda Gonzales","Arroz", "30kg","20/08/25","En camino"),
        Donaciones(1,"Mario Esparza", "Pollo Crudo(pechuga)", "90kg","23/08/25","En fundación"),
        Donaciones(2,"María Blaz","Variedad de verduras",  "20kg","07/08/25","En fundación"),
        Donaciones(3,"Bernardo Lopez", "Leguminosas", "120kg","28/07/25","En fundación"),
        Donaciones(4,"Diana Hernandez", "Frijol", "20kg","22/05/25","En fundación"),
        Donaciones(5,"Bernardo Lopez", "Cereales", "15kg","20/05/25","En fundación")
    )
}

class ListaDonacion : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KindBiteTheme {
                ListaDonaciones("Invitado")
            }
        }
    }
}

@Composable
fun CardDonante() {
    var donaciones by remember { mutableStateOf(DonacionesRepo.obtenerDonaciones()) }

    donaciones = DonacionesRepo.obtenerDonaciones()

    LazyColumn (modifier = Modifier.size(width = 500.dp, height = 700.dp)){
        items(donaciones) { donacion ->

            val textId = buildAnnotatedString {
                withStyle(SpanStyle(color = Color(0xFFFC8D3F))) { append("ID:") }
                withStyle(SpanStyle(color = Color.Black)) { append(" ${donacion.id}") }
            }

            val textProducto = buildAnnotatedString {
                withStyle(SpanStyle(color = Color(0xFFFC8D3F))) { append("Donación:") }
                withStyle(SpanStyle(color = Color.Black)) { append(" ${donacion.producto}") }
            }

            val textCantidad = buildAnnotatedString {
                withStyle(SpanStyle(color = Color(0xFFFC8D3F))) { append("Cantidad:") }
                withStyle(SpanStyle(color = Color.Black)) { append(" ${donacion.cantidad} kgs") }
            }

            val textFecha = buildAnnotatedString {
                withStyle(SpanStyle(color = Color(0xFFFC8D3F))) { append("Fecha de donación:") }
                withStyle(SpanStyle(color = Color.Black)) { append(" ${donacion.fecha}") }
            }

            Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFFFDF9ED)),
                shape = RectangleShape,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Text(textId,
                    modifier=Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center, style = TextStyle(fontSize = 14.sp))
                Text(
                    text = donacion.donador,
                    textAlign = TextAlign.Center,
                    style = TextStyle(fontSize = 15.sp, fontWeight = FontWeight.SemiBold),
                    modifier = Modifier.fillMaxWidth().padding(top = 10.dp)
                )
                Spacer(modifier = Modifier.size(9.dp))
                Text(textProducto,
                    modifier=Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center, style = TextStyle(fontSize = 14.sp))
                Text(textCantidad,
                    modifier=Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center, style = TextStyle(fontSize = 14.sp))
                Text(textFecha,
                    modifier=Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center, style = TextStyle(fontSize = 14.sp))
                Spacer(modifier = Modifier.size(20.dp))
                Divider(modifier = Modifier.fillMaxWidth().height(1.dp), color = Color(0xFFFC8D3F))
            }
        }
    }
}

@Composable
fun ListaDonaciones(nombre: String) {
    val bienvenida = "Hola $nombre!"
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFDF9ED))
            .padding(25.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Text("Lista de donaciones",
            style = TextStyle(fontSize = 24.sp, color = Color(0xFFFC8D3F), fontWeight = FontWeight.Bold)
        )
        Text(
            text = bienvenida,
            style = TextStyle(fontSize = 22.sp, fontWeight = FontWeight.ExtraLight)
        )
        Spacer(modifier = Modifier.size(15.dp))
        CardDonante()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MostrarLD(){
    ListaDonaciones(Sesion.usuarioActual?.nombre?:"Invitado")
}
