package edu.curso.agendacontato

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview


import androidx.compose.foundation.layout.padding
import androidx.compose.ui.unit.dp

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import agendacontato.composeapp.generated.resources.Res
import agendacontato.composeapp.generated.resources.compose_multiplatform


val nome = mutableStateOf("")
val telefone : MutableState<String> = mutableStateOf("")
val email : MutableState<String> = mutableStateOf("")
val lista : MutableState<List<Contato>> = mutableStateOf( listOf() )

fun gravar( ) { 
    val contato = Contato( nome.value, telefone.value, email.value )
    val novaLista : MutableList<Contato> = mutableListOf()
    novaLista.addAll( lista.value )
    novaLista.add( contato )
    lista.value = novaLista.toList()
    println("Lista possui ${lista.value.size} elementos")
    println(lista.value)
}

@Composable
@Preview
fun App() {
    MaterialTheme {
        Column( modifier = estiloPrincipal ) {
            Cabecalho()
            Formulario()
            Listagem()
        }
    }
}

@Composable
fun Formulario() { 
    Column(
        modifier = estiloFormulario
    ) {
        TextField(
            value = nome.value ,
            onValueChange = {
                novoNome -> nome.value = novoNome
            },
            placeholder = { Text("Digite seu nome completo") },
            label = { Text("Nome Completo") } 
        )
        TextField(
            value = telefone.value,
            onValueChange = { it -> telefone.value = it},
            placeholder = { Text("Informe o numero do telefone (dd)XXXX-XXXX") },
            label = { Text("Telefone") } 
        )
        TextField(
            value = email.value,
            onValueChange = {email.value = it},
            placeholder = { Text("Informe um email valido") },
            label = { Text("Email") } 
        )
        Button( onClick = { gravar() } ) {
            Text("Gravar")
        }
    }
}

@Composable
fun Listagem() {
    //     Column(
    //     modifier = Modifier
    //         .fillMaxHeight(0.5f)
    //         .fillMaxWidth()
    // ) {
        // for (contato in lista.value) { 
        //     Column (modifier = Modifier.padding(10.dp)) { 
        //         Text(contato.nome)
        //         Text(contato.telefone)
        //         Text(contato.email)
        //     }
        // }
    // }
    LazyColumn(modifier = Modifier
        .fillMaxHeight(0.9f)
        .fillMaxWidth()
        .background(color = Color.Blue)) {
        items(lista.value) { contato ->  
            Column (modifier = Modifier.padding(10.dp)) {
                Text(contato.nome)
                Text(contato.telefone)
                Text(contato.email)
            }
        }
    }
}

@Composable
fun Cabecalho() {
    Column(horizontalAlignment = Alignment.CenterHorizontally, 
            modifier = Modifier
                .background(color = Color.Yellow)
                .fillMaxWidth()
                .fillMaxHeight(0.1f)) {
        Text("Agenda de Contato")
        Text("Kotlin Multiplataforma")
        Button(onClick={}) {
            Text("Creditos")
        }
    }
}