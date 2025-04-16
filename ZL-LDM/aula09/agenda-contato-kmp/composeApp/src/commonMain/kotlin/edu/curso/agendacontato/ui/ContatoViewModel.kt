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
    val telefone : MutableState<String> = mutableStateOf("")
    val email : MutableState<String> = mutableStateOf("")
    val lista : MutableState<List<Contato>> = mutableStateOf( listOf() )
    val snackbarHostState = mutableStateOf( SnackbarHostState() )

    private val httpClient = createHttpClient()
    private val contatoApi = ContatoAPI( httpClient )


    fun cadastrarContato() {
        val contato = Contato( nome.value, telefone.value, email.value )

        viewModelScope.launch {
            contatoApi.gravar(contato)
            snackbarHostState.value.showSnackbar("Contato cadastrado com sucesso")
        }
    }

    fun lerTodos() {
        viewModelScope.launch {
            lista.value = contatoApi.lerTodos()
            snackbarHostState.value
                .showSnackbar("Foram lidos ${lista.value.size} contatos")
        }
    }


}