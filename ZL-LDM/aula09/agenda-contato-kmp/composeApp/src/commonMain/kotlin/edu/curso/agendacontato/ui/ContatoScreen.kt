package edu.curso.agendacontato.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import edu.curso.agendacontato.estiloFormulario

@Composable
fun Formulario( contatoViewModel : ContatoViewModel ) {
    Column(
        modifier = estiloFormulario
    ) {
        TextField(
            value = contatoViewModel.nome.value ,
            onValueChange = {
                    novoNome -> contatoViewModel.nome.value = novoNome
            },
            placeholder = { Text("Digite seu nome completo") },
            label = { Text("Nome Completo") }
        )
        TextField(
            value = contatoViewModel.telefone.value,
            onValueChange = { it -> contatoViewModel.telefone.value = it},
            placeholder = { Text("Informe o numero do telefone (dd)XXXX-XXXX") },
            label = { Text("Telefone") }
        )
        TextField(
            value = contatoViewModel.email.value,
            onValueChange = {contatoViewModel.email.value = it},
            placeholder = { Text("Informe um email valido") },
            label = { Text("Email") }
        )
        Button( onClick = {
            contatoViewModel.cadastrarContato()
        } ) {
            Text("Gravar")
        }
    }
}

@Composable
fun Listagem( contatoViewModel: ContatoViewModel ) {
    Column {
        Button(onClick = {
            contatoViewModel.lerTodos()
        }) {
            Text("Atualizar")
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxHeight(0.9f)
                .fillMaxWidth()
                .background(color = Color.Blue)
        ) {
            items(contatoViewModel.lista.value) { contato ->
                Column(modifier = Modifier.padding(10.dp)) {
                    Text(contato.nome)
                    Text(contato.telefone)
                    Text(contato.email)
                }
            }
        }

    }
}

@Composable
fun Cabecalho() {
    Row() {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(color = Color.Yellow)
                .fillMaxWidth()
                .fillMaxHeight(0.1f)) {
            Text("Agenda de Contato v1.2")
            Text("Kotlin Multiplataforma")
        }
    }
}

@Composable
fun ContatoNavHost(
    navController : NavHostController,
    contatoViewModel: ContatoViewModel
) {

    NavHost( navController = navController, startDestination = "FORM" ) {
        composable( "FORM" ) {
            Formulario(contatoViewModel)
        }
        composable( "LISTA" ) {
            Listagem(contatoViewModel)
        }
    }

}