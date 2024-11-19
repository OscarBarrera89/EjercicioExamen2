package com.oscarbarrera.examenEj2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    val selectedColor = remember { mutableStateOf(Color.Gray) }
    val colors = listOf(Color.Red, Color.Green, Color.Blue, Color.Yellow, Color.Cyan)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
    ) {
        ColorPicker(colors = colors, onColorSelected = { color ->
            selectedColor.value = color
        })
        Text(
            text = "Color Seleccionado",
            modifier = Modifier.padding(top = 16.dp)
        )
        Text(
            text = "   ",
            modifier = Modifier
                .padding(top = 8.dp)
                .background(selectedColor.value)
        )
    }
}

@Composable
fun ColorPicker(colors: List<Color>, onColorSelected: (Color) -> Unit) {
    LazyRow(
        modifier = Modifier.padding(top = 16.dp)
    ) {
        items(colors.size) { index ->
            val color = colors[index]
            Button(
                onClick = { onColorSelected(color) },
                modifier = Modifier.padding(end = 8.dp)
            ) {
                Text(text = "   ", color = Color.White, modifier = Modifier.background(color))
            }
        }
    }
}