package com.example.ejerciciosemana9

import android.R
import android.os.Bundle
import android.util.Printer
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.traceEventEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ejerciciosemana9.ui.theme.EjercicioSemana9Theme
import org.w3c.dom.Text
import java.io.BufferedReader
import java.nio.file.WatchEvent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EjercicioSemana9Theme {
            Scaffold(modifier = Modifier.fillMaxSize()) {innerPadding->
            }


                FormularioDeRegistro()
            }
        }
    }
}
@Composable
fun FormularioDeRegistro(){
    var personasAdentro by remember { mutableStateOf(0) }
    var ultimoRegistrado by remember { mutableStateOf("Ninguno") }
    var nombreInput by remember { mutableStateOf("") }
    Column(
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Text("CONTROL DE AFORO")
        Text(
            text = "Personas adentro: $personasAdentro"

        )

        Text(
            text = "Último registrado: $ultimoRegistrado"
        )
        if (personasAdentro>=3){
            Text("Solo se permiten 3 personas dentro")
        }

        OutlinedTextField(
            value = nombreInput,
            onValueChange = { nombreInput = it }
        )

        Button(
            onClick = {
                if (personasAdentro<3){
                    personasAdentro += 1
                    ultimoRegistrado = nombreInput
                }
                nombreInput = ""
            }
        ) {
            Text("Registrar e Ingresar")
        }
        Row(
        ) {
            Button(
                onClick = {
                    if (personasAdentro > 0) {
                        personasAdentro -= 1
                    }
                },
            ) {
                Text("Salida (-1)")
            }

            Button(
                onClick = {
                    personasAdentro = 0
                    ultimoRegistrado = "Ninguno"
                    nombreInput = ""
                }
            ) {
                Text("Reiniciar")
            }
        }
    }
}







