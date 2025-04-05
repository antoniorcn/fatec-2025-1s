package edu.curso.agendacontato.ui

import androidx.compose.material.SnackbarHostState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.curso.agendacontato.data.ContatoAPI
import edu.curso.agendacontato.data.createHttpClient
import edu.curso.agendacontato.domain.Contato
import kotlinx.coroutines.launch

class ContatoViewModel : ViewModel() {

    val nome = mutableStateOf("")
    val telefone = mutableStateOf("")
    val email = mutableStateOf("")
    val lista : MutableState<List<Contato>> = mutableStateOf(listOf())
    val snackBar = mutableStateOf( SnackbarHostState() )
    private val httpCliente = createHttpClient()
    private val api = ContatoAPI(httpCliente)

    init {
        lerTodosContatos()
    }

    fun cadastrarContato() {
        viewModelScope.launch {
            api.cadastrar(Contato(0, nome.value, email.value, telefone.value))
            snackBar.value.showSnackbar("Contato gravado com sucesso")

            lista.value = api.lerTodos()
            nome.value = ""
            telefone.value = ""
            email.value = ""
        }
    }

    fun lerTodosContatos() {
        viewModelScope.launch {
            lista.value = api.lerTodos()
            snackBar.value.showSnackbar("Foram lidos ${lista.value.size} contatos")
        }
    }

    fun apagarContato(contato : Contato) {
        viewModelScope.launch {
            api.apagar(contato)

            snackBar.value.showSnackbar("Contato apagado com sucesso")

            lista.value = api.lerTodos()
        }
    }

}