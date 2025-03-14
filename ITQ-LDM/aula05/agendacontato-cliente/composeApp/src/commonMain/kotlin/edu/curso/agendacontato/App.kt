package edu.curso.agendacontato

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import agendacontato.composeapp.generated.resources.Res
import agendacontato.composeapp.generated.resources.compose_multiplatform
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun App() {
    Column( modifier = Modifier
        .fillMaxSize()
        .padding(30.dp)
        .background(color = Color.Cyan, shape= RoundedCornerShape(20.dp))
        .padding(30.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally){
        Text("Ola Mundo Kotlin Multiplataforma")
        Text("Feito por Antonio Carvalho")
        Button(onClick = {
            println("Botão foi clicado com sucesso")
        }) {
            Text("Clique aqui")
        }
    }
}