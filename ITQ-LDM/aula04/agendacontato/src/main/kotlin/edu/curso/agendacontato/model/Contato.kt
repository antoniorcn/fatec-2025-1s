package edu.curso.agendacontato.model


import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Contato(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var id : Long,
    val nome : String,
    val email : String,
    val telefone : String
) {
    constructor() : this(0, "", "", "")
}