package edu.curso.agendacontato.domain

import kotlinx.serialization.Serializable

@Serializable
data class Contato (
    val nome : String,
    val telefone : String,
    val email : String
)