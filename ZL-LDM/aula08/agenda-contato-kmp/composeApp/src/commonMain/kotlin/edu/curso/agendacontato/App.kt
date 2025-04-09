package edu.curso.agendacontato


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import org.jetbrains.compose.ui.tooling.preview.Preview


val nome = mutableStateOf("")
val telefone : MutableState<String> = mutableStateOf("")
val email : MutableState<String> = mutableStateOf("")
val lista : MutableState<List<Contato>> = mutableStateOf( listOf() )
val snackbarHostState = mutableStateOf( SnackbarHostState() )

//fun gravar( ) {
//    val contato = Contato( nome.value, telefone.value, email.value )
//    val novaLista : MutableList<Contato> = mutableListOf()
//    novaLista.addAll( lista.value )
//    novaLista.add( contato )
//    lista.value = novaLista.toList()
//}

val URL_BASE = "http://192.168.15.7:8080"

suspend fun gravar() {
    val contato = Contato( nome.value, telefone.value, email.value )
    val clientHttp = createHttpClient()
    clientHttp.post(urlString = "$URL_BASE/contato"){
        contentType(ContentType.Application.Json)
        setBody( contato )
    }
}

suspend fun lerTodos() {
    val clientHttp = createHttpClient()
    val listaContatos = clientHttp
        .get("$URL_BASE/contato")
        .body<List<Contato>>()
    lista.value = listaContatos
}

@Composable
@Preview
fun App() {
    MaterialTheme {
        Scaffold( topBar = { Cabecalho() },
                snackbarHost = {
                    SnackbarHost( hostState = snackbarHostState.value)
                }
             ) {
            Column(modifier = estiloPrincipal.padding( it )) {
                Formulario()
                Listagem()
            }
        }
    }
}

@Composable
fun Formulario() {
    val scope = rememberCoroutineScope()
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
        Button( onClick = {
                scope.launch {
                    gravar()
                    snackbarHostState.value.showSnackbar("Contato cadastrado com sucesso")
                }
        } ) {
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
    val scope = rememberCoroutineScope()
    Column {
        Button(onClick = {
            scope.launch {
                lerTodos()
                snackbarHostState.value
                    .showSnackbar("Foram lidos ${lista.value.size} contatos")
            }
        }) {
            Text("Atualizar")
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxHeight(0.9f)
                .fillMaxWidth()
                .background(color = Color.Blue)
        ) {
            items(lista.value) { contato ->
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
    Column(horizontalAlignment = Alignment.CenterHorizontally, 
            modifier = Modifier
                .background(color = Color.Yellow)
                .fillMaxWidth()
                .fillMaxHeight(0.1f)) {
        Text("Agenda de Contato v1.2")
        Text("Kotlin Multiplataforma")
        Button(onClick={}) {
            Text("Creditos")
        }
    }
}