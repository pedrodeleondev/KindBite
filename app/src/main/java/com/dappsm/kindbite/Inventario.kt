package com.dappsm.kindbite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dappsm.kindbite.navigation.AppNavigation
import com.dappsm.kindbite.ui.theme.KindBiteTheme

class Inventario : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KindBiteTheme {
            }
        }
    }
}

data class Inventarios(val id:Int, val tipoDonacion:String, val Cantidad:Double)

fun inventarioBase():List<Inventarios>{
    return listOf(
        Inventarios(0,"Arroz", 30.0),
        Inventarios(1, "Pollo Crudo(pechuga)",  90.0),
        Inventarios(2,"Variedad de verduras",  20.0),
        Inventarios(3,"Leguminosas", 120.0),
        Inventarios(4,"Frijol", 20.0),
        Inventarios(5, "Cereales", 15.0)
    )
}

@Composable
fun cardInventario(){
    var inventario = inventarioBase()
    LazyColumn(modifier = Modifier.fillMaxWidth().fillMaxSize())
    {
        items(inventario) { alimento ->

            val textAlimento = buildAnnotatedString {
                withStyle(SpanStyle(color = Color.Black, fontWeight = FontWeight.Medium)) { append("- Alimento:") }
                withStyle(SpanStyle(color = Color.Black)) { append(" ${alimento.tipoDonacion}") }
            }

            val textCantidad = buildAnnotatedString {
                withStyle(SpanStyle(color = Color(0xFFFC8D3F), fontWeight = FontWeight.Medium)) { append("  Cantidad:") }
                withStyle(SpanStyle(color = Color.Black)) { append(" ${alimento.Cantidad} kgs" ) }
            }

            Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFFFDF9ED)),
                shape = RectangleShape,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Text(textAlimento,
                    modifier=Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Left, style = TextStyle(fontSize = 18.sp))
                Text(
                    text = textCantidad,
                    textAlign = TextAlign.Left,
                    style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Light),
                    modifier = Modifier.fillMaxWidth().padding(top = 5.dp)
                )
            }
        }
    }
}


@Composable
fun muestraInventario(){
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxSize()
        .background(Color(0xFFFDF9ED))
        .padding(10.dp)
    ) {
        Text(modifier = Modifier.padding(top = 18.dp), text = "Inventario de alimentos",
            style = TextStyle(fontSize = 24.sp, color = Color(0xFFFC8D3F), fontWeight = FontWeight.Bold)
        )
        Text(modifier = Modifier.padding(top = 2.dp), text = "Alimentos disponibles:",
            style = TextStyle(fontSize = 21.sp, fontWeight = FontWeight.ExtraLight)
        )
        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()
            .background(Color(0xFFFDF9ED))
            .padding(top = 10.dp)
        ) {
            cardInventario()
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MostrarIN(){
    muestraInventario()
}