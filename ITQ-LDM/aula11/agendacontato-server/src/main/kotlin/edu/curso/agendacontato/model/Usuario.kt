package edu.curso.agendacontato.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Usuario (
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id : Long,
    val email : String,
    val senha : String,
    val profile : String
) {
    constructor() : this(0, "", "", "")
}