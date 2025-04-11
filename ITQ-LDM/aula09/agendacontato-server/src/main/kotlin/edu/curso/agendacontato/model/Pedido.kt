package edu.curso.agendacontato.model

import jakarta.persistence.*
import jakarta.validation.Valid
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Past
import java.time.LocalDateTime

@Entity
data class Pedido (
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var id : Long,
    @field:NotEmpty
    val descricao : String,
    @field:Past
    val data : LocalDateTime,
    val dataEntrega : LocalDateTime,
    @field:NotEmpty
    val status : String,
    @ManyToOne
    @field:Valid
    var contato : Contato
) {
    constructor() : this(0, "",
        LocalDateTime.now(), LocalDateTime.now(), "", Contato())
}