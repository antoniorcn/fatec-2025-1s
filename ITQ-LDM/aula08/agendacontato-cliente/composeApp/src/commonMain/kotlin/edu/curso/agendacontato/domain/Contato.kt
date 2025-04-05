package edu.curso.agendacontato.domain

import kotlinx.serialization.Serializable

@Serializable
data class Contato (
    val id : Long = 0,
    val nome : String,
    val email : String,
    val telefone : String )