package edu.curso.agendacontato

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHost
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.List
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import edu.curso.agendacontato.ui.ContatoViewModel
import edu.curso.agendacontato.ui.FormularioContato
import edu.curso.agendacontato.ui.ListaContato
import org.jetbrains.compose.ui.tooling.preview.Preview

// val ciano = Color(0x77DDFFFF )

@Composable
@Preview
fun App() {
    MaterialTheme {
        val navController = rememberNavController()
        val contatoViewModel = viewModel {  ContatoViewModel() }

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Agenda de Contato") },
                    actions = {
                        IconButton(
                            onClick = {
                                navController.popBackStack()
                                navController.navigate("FORM")
                            }
                        ) {
                            Icon( Icons.Rounded.Edit,
                                    contentDescription = "Formulario" )
                        }
                        IconButton(
                            onClick = {
                                navController.popBackStack()
                                navController.navigate("LISTA")
                            }
                        ) {
                            Icon( Icons.AutoMirrored.Rounded.List,
                                contentDescription = "Listagem")
                        }
                    }
                )
            },
            snackbarHost = {
                SnackbarHost(hostState = contatoViewModel.snackBar.value)
            }
        ) { internalPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(internalPadding),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                AppNavHost(navController, contatoViewModel )
            }
        }
    }
}

@Composable
fun AppNavHost(navController : NavHostController,
               contatoViewModel: ContatoViewModel ) {
    NavHost( navController = navController, startDestination = "FORM" ) {
        composable("FORM") {
            FormularioContato( contatoViewModel )
        }
        composable("LISTA") {
            ListaContato( contatoViewModel )
        }
    }
}

