package com.oscarbarrera.examenEj2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.oscarbarrera.examenEj2.ui.theme.EjercicioExamen2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EjercicioExamen2Theme {
                SeleccionarColor()
            }
        }
    }
}

@Preview
@Composable
fun SeleccionarColor() {
    val colorSelec by remember { mutableStateOf("") }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Text(text = "Color")
        }
    ) { innerPadding ->
        Row(
            modifier = Modifier.padding(innerPadding)
        ) {
            ListaColores(colorSelec)
        }
    }
}

@Composable
fun ListaColores(color: String) {

    var colorSelec by remember { mutableStateOf(color) }

    Text(text = "Rojo", modifier = Modifier.padding(start = 16.dp), color = androidx.compose.ui.graphics.Color.Red)
    Text(text = "Verde", modifier = Modifier.padding(start = 16.dp), color = androidx.compose.ui.graphics.Color.Green)
    Text(text = "Azul", modifier = Modifier.padding(start = 16.dp), color = androidx.compose.ui.graphics.Color.Blue)
    Text(text = "Amarillo", modifier = Modifier.padding(start = 16.dp), color = androidx.compose.ui.graphics.Color.Yellow)
    Text(text = "Gris", modifier = Modifier.padding(start = 16.dp), color = androidx.compose.ui.graphics.Color.Gray)
    Text(text = "Negro", modifier = Modifier.padding(start = 16.dp), color = androidx.compose.ui.graphics.Color.Black)
    Text(text = "Blanco", modifier = Modifier.padding(start = 16.dp), color = androidx.compose.ui.graphics.Color.White)

    Column {
        TextField(value = colorSelec, onValueChange = { colorSelec = it }, label = { Text("Seleccione un color") }, modifier = Modifier.fillMaxWidth())
        Text(text = "Color seleccionado: $colorSelec", modifier = Modifier.padding(top = 16.dp))
    }

}