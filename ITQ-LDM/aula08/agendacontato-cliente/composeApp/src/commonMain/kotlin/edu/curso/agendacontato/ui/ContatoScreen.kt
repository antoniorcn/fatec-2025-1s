package edu.curso.agendacontato.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ListaContato(contatoViewModel: ContatoViewModel) {
    Column (modifier = Modifier.fillMaxWidth()
        .fillMaxHeight(0.9f)) {
        Button( onClick = {
            contatoViewModel.lerTodosContatos()
        }) {
            Text("Carregar Dados")
        }
        LazyColumn(modifier = Modifier
            .fillMaxHeight(0.7f)
            .fillMaxWidth()) {
            items(contatoViewModel.lista.value) { contato ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .padding( 20.dp )
                        .background(color = Color(0xFFFFFFCC), shape = RoundedCornerShape(16.dp) )
                        .border(width = 2.dp, color= Color.Red, shape = RoundedCornerShape(16.dp))
                        .padding( 10.dp )
                ) {
                    Text("Nome: ${contato.nome}")
                    Text("Telefone: ${contato.telefone}")
                    Text("Email: ${contato.email}")
                    Button(onClick = {
                        contatoViewModel.apagarContato(contato)
                    }) { Text("Apagar") }
                }
            }
        }
    }
}

@Composable
fun FormularioContato(contatoViewModel: ContatoViewModel) {
    Column (verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(color= Color.LightGray)
            .padding(vertical = 50.dp)
            .fillMaxWidth()
            .fillMaxHeight(0.9f)

    ) {
        Text(text = "Agenda de Contato", fontSize = 48.sp)

        OutlinedTextField(value = contatoViewModel.nome.value,
            onValueChange = { texto -> contatoViewModel.nome.value = texto },
            label = { Text("Nome Completo") },
            placeholder = { Text("Informe o nome completo do contato") },
            modifier = Modifier.fillMaxWidth(0.8f))

        OutlinedTextField(value = contatoViewModel.telefone.value,
            onValueChange = { texto -> contatoViewModel.telefone.value = texto },
            label = { Text("Telefone") },
            placeholder = { Text("Informe o telefone  (XX) XXXX-XXXX") },
            modifier = Modifier.fillMaxWidth(0.8f))

        OutlinedTextField(value = contatoViewModel.email.value,
            onValueChange = { contatoViewModel.email.value = it },
            label = { Text("Email") },
            placeholder = { Text("Informe um endereço de email válido") },
            modifier = Modifier.fillMaxWidth(0.8f))

        Button( onClick = {
            contatoViewModel.cadastrarContato()
        } ) {
            Text("Adicionar")
        }
    }
}