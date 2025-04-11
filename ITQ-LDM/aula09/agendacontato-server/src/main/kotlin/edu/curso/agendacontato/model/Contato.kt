package edu.curso.agendacontato.model


import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import org.hibernate.validator.constraints.Length
import org.hibernate.validator.constraints.Range

@Entity
data class Contato(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var id : Long,
    @field:NotEmpty
    val nome : String,
    @field:Email
    val email : String,
    @field:Length(min=10, max=15)
    val telefone : String
) {
    constructor() : this(0, "", "", "")
}