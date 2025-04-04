package edu.curso.agendacontato

import kotlinx.serialization.Serializable

@Serializable
data class Contato (
    val id : Long = 0,
    val nome : String,
    val email : String,
    val telefone : String ) {
}