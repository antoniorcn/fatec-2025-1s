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
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.MutableLongState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

val teste : MutableList<String> = mutableListOf()

val nome = mutableStateOf("")
val telefone = mutableStateOf("")
val email = mutableStateOf("")

val contador : MutableLongState = mutableLongStateOf( 0 )

val tela : MutableState<String> = mutableStateOf("LIST")

val lista : MutableState<List<Contato>> = mutableStateOf(listOf())

val ciano = Color(0x77DDFFFF )

// val status = mutableStateOf<String?>(null)
val snackBar = mutableStateOf( SnackbarHostState() )


fun navegar(direcao : String) {
    tela.value = direcao
    // status.value = null
}

@Composable
@Preview
fun App() {
    MaterialTheme {
        val httpCliente = createHttpClient()
        val api = ContatoAPI(httpCliente)
        val escopo = rememberCoroutineScope()
        lerTodosContatos(api, escopo )
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Agenda de Contato") }
                )
            },
            snackbarHost = {
                SnackbarHost(hostState = snackBar.value)
            }
        ) { internalPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(internalPadding),
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                if (tela.value == "FORM") {
                    FormularioContato(api, escopo)
                } else {
                    ListaContato(api, escopo)
                }
            }
        }
    }
}

fun cadastrarContato( api: ContatoAPI, escopo : CoroutineScope) {
    escopo.launch {
        api.cadastrar(Contato(0, nome.value, email.value, telefone.value))
        // status.value = "Contato gravado com sucesso"
        escopo.launch {
            snackBar.value.showSnackbar("Contato gravado com sucesso")
        }
        lista.value = api.lerTodos()
        nome.value = ""
        telefone.value = ""
        email.value = ""
    }
}

fun lerTodosContatos( api : ContatoAPI, escopo: CoroutineScope) {
    escopo.launch {
        lista.value = api.lerTodos()
        // status.value = "Contatos lidos com sucesso"
        escopo.launch {
            snackBar.value.showSnackbar("Foram lidos ${lista.value.size} contatos")
        }
    }
}

fun apagarContato( api: ContatoAPI, escopo : CoroutineScope, contato : Contato) {
    escopo.launch {
        api.apagar(contato)
        // status.value = "Contato apagado com sucesso"
        escopo.launch {
            snackBar.value.showSnackbar("Contato apagado com sucesso")
        }
        lista.value = api.lerTodos()
    }
}

@Composable
fun ListaContato(api: ContatoAPI, escopo: CoroutineScope) {
    Column (modifier = Modifier.fillMaxWidth()
        .fillMaxHeight(0.9f)) {
        Button( onClick = {
            lerTodosContatos(api, escopo)
        }) {
            Text("Carregar Dados")
        }
        LazyColumn(modifier = Modifier
            .fillMaxHeight(0.7f)
            .fillMaxWidth()) {
            items(lista.value) { contato ->
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
                    Button(onClick = {
                        apagarContato(api, escopo, contato)
                    }) { Text("Apagar") }
                }
            }
        }
        Column(modifier = Modifier
            .fillMaxHeight(0.3f)) {
            Button(onClick = { navegar("FORM") }) {
                Text("Formulario")
            }
        }
    }
}

@Composable
fun FormularioContato(api: ContatoAPI, escopo: CoroutineScope) {
    Column (verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(color= ciano)
            .padding(vertical = 50.dp)
            .fillMaxWidth()
            .fillMaxHeight(0.9f)

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

        Button( onClick = {
            cadastrarContato(api, escopo)
        } ) {
            Text("Adicionar")
        }
        Button(onClick = { navegar("LIST") }) {
            Text("Listagem")
        }
    }
}