package edu.curso.agendacontato

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background

import agendacontato.composeapp.generated.resources.Res
import agendacontato.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    MaterialTheme {
        Column( modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color.Cyan) ) {
            Cabecalho()
            Column(
                modifier = Modifier.fillMaxHeight()
            ) {
                TextField(
                    value = "",
                    onValueChange = {},
                    placeholder = { Text("Digite seu nome completo") },
                    label = { Text("Nome Completo:") } 
                )
            }
        }
    }
}

@Composable
fun Cabecalho() {
    Column(horizontalAlignment = Alignment.CenterHorizontally, 
            modifier = Modifier
                .background(color = Color.Yellow)
                .fillMaxWidth() ) {
        Text("Agenda de Contato")
        Text("Kotlin Multiplataforma")
        Button(onClick={}) {
            Text("Creditos")
        }
    }
}