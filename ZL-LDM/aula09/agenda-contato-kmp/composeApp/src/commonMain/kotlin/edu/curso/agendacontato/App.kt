package edu.curso.agendacontato


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.rounded.List
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import edu.curso.agendacontato.ui.Cabecalho
import edu.curso.agendacontato.ui.ContatoNavHost
import edu.curso.agendacontato.ui.ContatoViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun App() {
    MaterialTheme {

        val navController = rememberNavController()
        val contatoViewModel = viewModel { ContatoViewModel() }

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Agenda de Contato") } ,
                    navigationIcon = {
//                        if (navController.currentBackStack.value.size > 0) {
                        IconButton(onClick = {
                            navController.popBackStack()
                        }) {
                            Icon(Icons.AutoMirrored.Rounded.KeyboardArrowLeft, contentDescription = "Formulario")
                        }
//                        }
                    },
                    actions = {
                        IconButton(onClick = {
                            navController.navigate("FORM")
                        }) {
                            Icon(Icons.Rounded.Edit, contentDescription = "Formulario")
                        }
                        IconButton(onClick = {
                            navController.navigate("LISTA")
                        }) {
                            Icon(Icons.AutoMirrored.Rounded.List, contentDescription = "Listagem")
                        }
                    }
                )
            },
            snackbarHost = {
                SnackbarHost( hostState = contatoViewModel.snackbarHostState.value)
            }
        ) {
            Column(modifier = estiloPrincipal.padding( it )) {
                ContatoNavHost( navController, contatoViewModel )
            }
        }
    }
}

