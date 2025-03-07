package edu.curso.agendacontato.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Pedido (
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var id : Long,
    val descricao : String,
    val data : LocalDateTime,
    val dataEntrega : LocalDateTime,
    val status : String,
    @ManyToOne
    var contato : Contato
) {
    constructor() : this(0, "",
        LocalDateTime.now(), LocalDateTime.now(), "", Contato())
}