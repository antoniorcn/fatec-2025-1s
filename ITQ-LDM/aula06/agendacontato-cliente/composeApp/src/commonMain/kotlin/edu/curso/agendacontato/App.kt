package edu.curso.agendacontato

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview
import androidx.compose.material.Text
import androidx.compose.runtime.MutableLongState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val nome = mutableStateOf("")
val telefone = mutableStateOf("")
val email = mutableStateOf("")

val contador : MutableLongState = mutableLongStateOf( 0 )

val tela : MutableState<String> = mutableStateOf("LIST")

val lista : MutableList<Contato> = mutableListOf(
    Contato(1, "Joao Silva", "joao@teste.com", "(11) 1111-1111"),
    Contato(1, "Maria Silva", "maria@teste.com", "(11) 2222-2222"),
    Contato(1, "Jose Silva", "jose@teste.com", "(11) 3333-3333")

)

val ciano = Color(0x77DDFFFF )

fun adicionar() {
    println("Botão adicionar apertado=>")
    println("Nome: ${nome.value}")
    println("Telefone: ${telefone.value}")
    println("Email: ${email.value}")
    contador.value += 1
    val contato = Contato(id = contador.value, nome = nome.value, telefone = telefone.value, email = email.value )
    lista.add( contato )
    println( lista )
}

@Composable
@Preview
fun App() {
    MaterialTheme {
        if (tela.value == "FORM") FormularioContato() else ListaContato()
    }
}

@Composable
fun ListaContato() {
    Column (modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier
            .fillMaxHeight(0.7f)
            .fillMaxWidth()) {
            items(lista) { contato ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .padding( 20.dp )
                        .background(color = Color(0xFFFFFFCC), shape = RoundedCornerShape(16.dp) )
                        .border(width = 2.dp, color=Color.Red, shape = RoundedCornerShape(16.dp))
                        .padding( 10.dp )
                ) {
                    Text("Nome: ${contato.nome}")
                    Text("Telefone: ${contato.telefone}")
                    Text("Email: ${contato.email}")
                }
            }
        }
        Column(modifier = Modifier
            .fillMaxHeight(0.3f)) {
            Button(onClick = { tela.value = "FORM" }) {
                Text("Formulario")
            }
        }
    }
}

@Composable
fun FormularioContato() {
    Column (verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(color= ciano)
            .padding(vertical = 50.dp)
            .fillMaxSize()

    ) {
        Text(text = "Agenda de Contato", fontSize = 48.sp)

        OutlinedTextField(value = nome.value, onValueChange = { texto -> nome.value = texto },
            label = {Text("Nome Completo")},
            placeholder = { Text("Informe o nome completo do contato") },
            modifier = Modifier.fillMaxWidth(0.8f))

        OutlinedTextField(value = telefone.value, onValueChange = { texto -> telefone.value = texto },
            label = {Text("Telefone")},
            placeholder = { Text("Informe o telefone  (XX) XXXX-XXXX") },
            modifier = Modifier.fillMaxWidth(0.8f))

        OutlinedTextField(value = email.value, onValueChange = { email.value = it },
            label = {Text("Email")},
            placeholder = { Text("Informe um endereço de email válido") },
            modifier = Modifier.fillMaxWidth(0.8f))

        Button( onClick = { adicionar() } ) {
            Text("Adicionar")
        }
        Button(onClick = { tela.value = "LIST" }) {
            Text("Listagem")
        }
    }
}